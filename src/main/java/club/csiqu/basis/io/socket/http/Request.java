package club.csiqu.basis.io.socket.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

class Request {

    private static final Logger LOGGER = LoggerFactory.getLogger(Request.class);

    private InputStream inputStream;

    private String uri;

    Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    void parse() {
        StringBuilder requestStr = new StringBuilder(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            LOGGER.warn("读取客户端发送的数据流出现异常，可能为客户端断开连接：{}", e.getMessage());
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            requestStr.append((char)buffer[j]);
        }
        this.uri = parseUri(requestStr.toString());
    }

    private String parseUri(String requestStr) {
        int index1, index2;
        index1 = requestStr.indexOf(' ');
        if (index1 != -1) {
            index2 = requestStr.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                requestStr = requestStr.substring(index1 + 1, index2);
                return requestStr;
            }
        }
        return null;
    }

    String getUri() {
        return this.uri;
    }
}