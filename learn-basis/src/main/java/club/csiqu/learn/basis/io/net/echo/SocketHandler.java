package club.csiqu.learn.basis.io.net.echo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Siqu Chen 2020/5/7
 * @since 1.0.0
 */
public class SocketHandler implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketHandler.class);

    private final Socket socket;

    SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("接入的客户端主机地址：{}", socket.getRemoteSocketAddress());
            }
            String s = in.readUTF();
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("服务端读取到的数据为：{}", s);
            }
            out.writeUTF(s);
        } catch (IOException e) {
            LOGGER.warn("socket读写数据时发生异常：{}", e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.warn("关闭socket连接出现异常：{}", e.getMessage());
            }
        }
    }
}