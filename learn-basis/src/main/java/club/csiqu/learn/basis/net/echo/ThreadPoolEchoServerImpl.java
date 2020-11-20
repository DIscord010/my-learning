package club.csiqu.learn.basis.net.echo;

import club.csiqu.learn.basis.net.AbstractStopServer;
import club.csiqu.learn.basis.Executors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 15:04
 */
public class ThreadPoolEchoServerImpl extends AbstractStopServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolEchoServerImpl.class);

    /** 接收客户端连接请求线程 */
    private final Executor bossExecutor = Executors.newSingleThreadExecutor("echo-server-pool-boss-%d");

    /** 客户端连接处理线程 */
    private final Executor workExecutor = new ThreadPoolExecutor(
            5,
            10,
            5L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("echo-server-pool-work-%d").build());

    private final ServerSocket serverSocket;

    public ThreadPoolEchoServerImpl(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Server start.");
        }
    }

    @Override
    public void service() {
        bossExecutor.execute(() -> {
            while (serviceFlag) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    LOGGER.warn("建立socket连接时出现异常：{}", e.getMessage());
                }
                if (socket != null) {
                    workExecutor.execute((new SocketHandler(socket)));
                }
            }
        });
    }
}