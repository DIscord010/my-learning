package club.csiqu.basis.io.http;

import java.io.IOException;
import java.io.InputStream;

class Request {

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
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            requestStr.append((char) buffer[j]);
        }
        System.out.println(requestStr.toString());
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