package club.csiqu.basis.io.socket.echo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务端（多线程，每次接收连接则新建一个线程处理）
 * <p>
 * 每次接收到连接就新建一个线程进行处理。
 * 收到数据后将该数据回传。（新建一个线程大约需要 1M的内存，且线程创建和销毁需要大量开销）
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 13:55
 */
public class EchoServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class);

    private ServerSocket serverSocket;

    EchoServer() throws IOException {
        int port = 8000;
        serverSocket = new ServerSocket(port);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("EchoServer start");
        }
    }

    public void service() {
        new Thread(() -> {
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    LOGGER.warn("建立socket连接时出现异常：{}", e.getMessage());
                }
                if (socket != null) {
                    Thread workThread = new Thread(new Handler(socket));
                    workThread.start();
                }
            }
        }).start();
    }

    static class Handler implements Runnable {

        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("接入主机地址： {}", socket.getRemoteSocketAddress());
                }
                String s = in.readUTF();
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("服务端读取到的数据为： {}", s);
                }
                out.writeUTF(s);
            } catch (IOException e) {
                LOGGER.warn("socker读写数据时发生异常：{}", e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        LOGGER.warn("关闭socket连接出现异常：{}", e.getMessage());
                    }
                }
            }
        }
    }
}