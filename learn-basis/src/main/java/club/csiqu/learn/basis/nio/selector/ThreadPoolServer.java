package club.csiqu.learn.basis.nio.selector;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 18:14
 */
public class ThreadPoolServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadPoolServer.class);

    private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("nio-server-pool-%d").build();

    private Executor executor = new ThreadPoolExecutor(
            5,
            10,
            5L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            namedThreadFactory);

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private void init(int port) throws IOException {

        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void listen() throws IOException {

        LOGGER.info("server succeed start!");
        // select()方法会阻塞线程，直到有事件准备就绪
        // 且会阻塞 register()方法执行
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey readyKey = it.next();
                if (readyKey.isAcceptable()) {
                    LOGGER.info("客户端接入：");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (readyKey.isReadable()) {
                    // 此处取消注册，防止可读事件再次触发，造成同一可读事件 channel多线程处理导致异常的发生
                    // 当 socketChannel.read(buffer)为 0时表示无数据可读
                    // 如果此时进行线程空转则继续获取数据会导致如果客户端因某些事件阻塞过久，则服务端线程空转耗费 CPU资源
                    // 如果为 0时（暂无数据）调用 register()方法重新绑定，与 select()方法是同步的，在连接数过小的情况下，
                    // 由于 selector.select()的阻塞，会导致子线程因 register()方法也阻塞无法继续执行。
                    // 且若主线程执行很慢，在没有执行 select()方法之前就调用 register()方法会抛出异常
                    // cancel() --> re-register()会抛出 CancelledKeyException异常
                    // 也就是说需要保持这样的执行顺序 cancel() --> select() --> re-register()
                    // 因为 cancel()方法是在下次 select()方法时才移除该 key的绑定事件
                    readyKey.cancel();
                    LOGGER.info("可读事件：");
                    executor.execute(new Handler((SocketChannel)readyKey.channel(), selector));
                }
                it.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ThreadPoolServer server = new ThreadPoolServer();
        server.init(8080);
        server.listen();
    }

    static class Handler implements Runnable {

        private SocketChannel socketChannel;

        private Selector selector;

        Handler(SocketChannel socketChannel, Selector selector) {
            this.socketChannel = socketChannel;
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                SelectorSample.print(socketChannel, selector);
            } catch (IOException e) {
                LOGGER.warn("IO异常：{}", e.getMessage());
            }
        }
    }
}