package club.csiqu.learn.basis.io.socket.echo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 15:04
 */
public class ThreadPoolEchoServer {

    private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("echo-server-pool-%d").build();

    private Executor executor = new ThreadPoolExecutor(
            5,
            10,
            5L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            namedThreadFactory);

    private ServerSocket serverSocket;

    private ThreadPoolEchoServer() throws IOException {

        int port = 8000;
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void service() {
        while (true) {

            try {
                Socket socket = serverSocket.accept();
                executor.execute(new EchoServer.Handler(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ThreadPoolEchoServer().service();
    }
}