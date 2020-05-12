package club.csiqu.learn.basis.io.net.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Siqu Chen
 */
public class Request {

    private static final Logger LOGGER = LoggerFactory.getLogger(Request.class);

    /**
     * 客户端连接输入流
     */
    private final InputStream inputStream;

    /**
     * 获取到的 HTTP协议中的路径信息
     */
    private String path;

    private static final char ONE_SPACE = ' ';

    Request(InputStream inputStream) {
        this.inputStream = inputStream;
        parseRequestLine();
    }

    /**
     * 获取 HTTP请求的请求行，按协议规定结束标志为 {@code "\r\n"}。
     */
    void parseRequestLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            this.path = parsePath(reader.readLine());
        } catch (IOException e) {
            LOGGER.warn("读取请求行时出现IO异常：{}", e.getMessage());
        }
    }

    /**
     * HTTP协议请求行的格式为 [请求方法 请求路径 协议版本] e.g. [GET /test HTTP/1.1]
     *
     * @param requestStr 请求行
     * @return 路径信息
     */
    private String parsePath(String requestStr) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("HTTP请求的头部信息为：{}", requestStr);
        }
        int index0;
        int index1;
        index0 = requestStr.indexOf(ONE_SPACE);
        if (index0 != -1) {
            index1 = requestStr.indexOf(ONE_SPACE, index0 + 1);
            if (index1 > index0) {
                requestStr = requestStr.substring(index0 + 1, index1);
                return requestStr;
            }
        }
        return null;
    }

    public String getPath() {
        return path;
    }
}