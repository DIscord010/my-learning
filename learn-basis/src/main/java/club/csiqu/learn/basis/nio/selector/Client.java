package club.csiqu.learn.basis.nio.selector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/28 14:22
 */
public class Client {

    private final static Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {

        try (SocketChannel socketChannel = SocketChannel.open()) {
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
            socketChannel.connect(socketAddress);
            byte[] bytes1 = {1, 1, 1};
            socketChannel.write(ByteBuffer.wrap(bytes1));
            Thread.sleep(10000);
            byte[] bytes2 = {2, 2, 2};
            socketChannel.write(ByteBuffer.wrap(bytes2));
            socketChannel.socket().shutdownOutput();
            socketChannel.socket().close();

        } catch (IOException | InterruptedException e) {
            LOGGER.error("客户端IO异常：{}", e.getMessage());
        }
    }
}