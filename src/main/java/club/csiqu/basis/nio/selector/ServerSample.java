package club.csiqu.basis.nio.selector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO服务端示例
 * <p>
 * 服务通道设置为非阻塞，绑定 {@link SelectionKey#OP_ACCEPT}事件。
 * 当有客户端连接时，设置客户端连接通道为非阻塞，绑定 {@link SelectionKey#OP_READ}事件。
 * 单线程对可读通道进行处理。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 17:05
 */
public class ServerSample {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerSample.class);

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
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {

                SelectionKey readyKey = it.next();
                if (readyKey.isAcceptable()) {
                    LOGGER.info("客户端接入");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);

                } else if (readyKey.isReadable()) {
                    // 此处客户端关闭连接 channel，但是服务端未关闭客户连接 channel时，会无限产生可读事件
                    LOGGER.info("可读事件：");
                    SelectorSample.print((SocketChannel) readyKey.channel(), null);
                }
                it.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ServerSample serverSample = new ServerSample();
        serverSample.init(8080);
        serverSample.listen();
    }
}