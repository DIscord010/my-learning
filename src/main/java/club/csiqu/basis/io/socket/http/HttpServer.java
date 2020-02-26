package club.csiqu.basis.io.socket.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟简单 Web 服务器，对一个请求进行响应。
 *
 * @author chensiqu
 */
public class HttpServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public void await() {
        ServerSocket serverSocket;
        int port = 8080;
        // 是否可以打开对应 ip + 端口
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            LOGGER.warn("HTTP服务器打开错误：{}", e.getMessage());
            throw new RuntimeException();
        }
        while (!shutdown) {
            try (Socket socket = serverSocket.accept();
                 InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {
                // 创建 request 对象并进行解析
                Request request = new Request(inputStream);
                request.parse();
                // 创建 response 对象
                Response response = new Response(outputStream);
                response.setRequest(request);
                response.sendStaticResource();
                socket.close();
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (IOException e) {
                LOGGER.warn("{}", e.getMessage());
            }
        }
    }
}