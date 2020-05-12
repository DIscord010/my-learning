package club.csiqu.learn.basis.io.net.echo;

import club.csiqu.learn.basis.io.net.AbstractStopServer;
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
 * Echo Server.
 * <p>
 * 收到数据后将该数据回传。
 * <p>
 * 每次收到连接请求就新建一个线程进行处理（新建一个线程大约需要 1M的内存，且线程创建和销毁需要大量开销）。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 13:55
 */
public class EchoServerImpl extends AbstractStopServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServerImpl.class);

    /** 接收客户端连接请求线程 */
    private final Executor executor = new ThreadPoolExecutor(
            1,
            1,
            5L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("echo-server-pool-%d").build());

    private final ServerSocket serverSocket;

    EchoServerImpl() throws IOException {
        int port = 8000;
        serverSocket = new ServerSocket(port);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("EchoServer start");
        }
    }

    @Override
    public void service() {
        executor.execute(() -> {
            while (serviceFlag) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    LOGGER.warn("建立socket连接时出现异常：{}", e.getMessage());
                }
                if (socket != null) {
                    Thread workThread = new Thread(new SocketHandler(socket));
                    workThread.start();
                }
            }
        });
    }
}