package club.csiqu.learn.basis.io.net.http;

import club.csiqu.learn.basis.io.net.ExecutorFactory;
import club.csiqu.learn.basis.io.net.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;

/**
 * 简单实现 HTTP服务器，对一个请求进行响应。
 *
 * @author chensiqu
 */
public class HttpServer implements Server {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webRoot";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private volatile boolean shutdown = false;

    private final ServerSocket serverSocket;

    /** 单线程进行连接请求处理和客户端连接处理 */
    private final Executor executor = ExecutorFactory.newSingleThreadExecutor("http-server-pool-%d");

    public HttpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void service() {
        executor.execute(() -> {
            while (!shutdown) {
                try (Socket socket = serverSocket.accept();
                     InputStream inputStream = socket.getInputStream();
                     OutputStream outputStream = socket.getOutputStream()) {
                    // 创建 request对象并进行解析
                    Request request = new Request(inputStream);
                    if (request.getPath().equals(SHUTDOWN_COMMAND)) {
                        stopService();
                        break;
                    }
                    // 创建 response对象
                    Response response = new Response(outputStream);
                    response.setRequest(request);
                    response.sendStaticResource();
                } catch (IOException e) {
                    LOGGER.warn("{}", e.getMessage());
                }
            }
        });
    }

    @Override
    public void stopService() {
        this.shutdown = true;
    }
}