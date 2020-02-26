package club.csiqu.basis.nio.selector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 单线程轮训判断是否有客户端接入，有客户端连接则进行处理。
 * 在这种使用情况，个人认为基本与 BIO一致。只是 BIO在获取客户端接入时会阻塞，而此例中没有客户端接入的话会继续轮训。
 * 在有连接的情况下，也只是单线程遍历获取连接进行操作。无法同时处理多客户端接入的场景。
 * 因为客户端连接 {@code socketChannel}未设置非阻塞模式，在读取数据时，如果没有数据则会阻塞等待。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/28 9:32
 */
public class SelectorSample {

    private final static Logger LOGGER = LoggerFactory.getLogger(SelectorSample.class);

    public static void main(String[] args) {

        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().setReuseAddress(true);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {

                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {

                    SelectionKey readyKey = it.next();
                    it.remove();
                    execute((ServerSocketChannel) readyKey.channel());
                }
            }
        } catch (IOException e) {
            LOGGER.error("IO异常：{}", e.getMessage());
        }
    }

    private static void execute(ServerSocketChannel serverSocketChannel) {

        try (SocketChannel socketChannel = serverSocketChannel.accept()) {
            print(socketChannel, null);

        } catch (IOException e) {
            LOGGER.error("IO异常：{}", e.getMessage());
        }
    }

    public static void print(SocketChannel socketChannel, Selector selector) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(48);
        // read into buffer
        int bytesRead = socketChannel.read(buffer);

        while (bytesRead > 0) {
            System.out.println("Read " + bytesRead + " Bytes");
            buffer.flip();
            // 按字节读取
            while (buffer.hasRemaining()) {
                LOGGER.info(String.valueOf(buffer.get()));
            }
            buffer.clear();
            bytesRead = socketChannel.read(buffer);
        }
        if (bytesRead == -1) {
            socketChannel.close();
            LOGGER.info("客户端连接关闭");
        }
        if (bytesRead == 0) {
            if (selector != null) {
                // register()方法会被 selector.select()方法阻塞
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
        }
    }
}