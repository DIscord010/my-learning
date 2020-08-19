package club.csiqu.learn.basis.net.greeting;

import club.csiqu.learn.basis.net.AbstractStopServer;
import club.csiqu.learn.basis.executor.ExecutorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;

/**
 * 单线程 Socket服务端
 * <p>
 * 单线程处理连接，在一个连接未完成之时，并不会获取新的客户端连接。
 * 无法同时接收并处理多个客户端连接，客户端必须排队等待服务端的响应。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 11:48
 */
public class GreetingServerImpl extends AbstractStopServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServerImpl.class);

    private final ServerSocket serverSocket;

    /** 单线程进行连接请求处理和客户端连接处理 */
    private final Executor executor = ExecutorFactory.newSingleThreadExecutor("greeting-server-pool-%d");

    public GreetingServerImpl(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        // 10000为 10秒
        serverSocket.setSoTimeout(300000);
    }

    /**
     * 获取客户端连接，当没有连接时阻塞，获取连接后读取发送数据后即关闭此连接。
     * 当客户端未发送数据时，会一直阻塞等待，直到客户端发送数据后此服务端收到数据。
     * 且在获取数据时，其他客户端无法接入。
     */
    @Override
    public void service() {
        executor.execute(() -> {
            while (serviceFlag) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("等待远程连接，端口号为：{}...", serverSocket.getLocalPort());
                }
                try (Socket server = serverSocket.accept();
                     DataInputStream in = new DataInputStream(server.getInputStream());
                     DataOutputStream out = new DataOutputStream(server.getOutputStream())) {
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("远程主机地址：{}", server.getRemoteSocketAddress());
                        LOGGER.info("收到的数据为：{}", in.readUTF());
                    }
                    out.writeUTF("谢谢连接我：" + server.getLocalAddress() + " Goodbye！");
                } catch (IOException e) {
                    LOGGER.warn("客户端IO连接异常，可能为网络突然断开");
                }
            }
        });
    }
}