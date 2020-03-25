package club.csiqu.learn.basis.io.socket.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class Response {

    private static final Logger LOGGER = LoggerFactory.getLogger(Response.class);

    /** 支持的文件最长长度 */
    private static final int BUFFER_SIZE = 1024;

    private Request request;

    private OutputStream outputStream;

    Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    void setRequest(Request request) {
        this.request = request;
    }

    void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        // 读取静态文件并发送响应流
        FileInputStream fileInputStream = null;
        try {
            // 读取指定路径的静态文件
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("读取的文件URI为：{}", HttpServer.WEB_ROOT + request.getUri());
            }
            if (file.exists()) {
                // 文件存在则拼接 HTTP协议头和内容
                String message = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n";
                fileInputStream = new FileInputStream(file);
                // 获取文件长度，进行拼接
                int ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
                String length = "Content-Length: " + ch + "\r\n";
                outputStream.write((message + length + "\r\n").getBytes(StandardCharsets.UTF_8));
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                // 文件未找到
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(errorMessage.getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            LOGGER.warn("发送响应数据中发生异常，可能为客户端断开连接");
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }
}