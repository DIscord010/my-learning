package club.csiqu.learn.framework.spring.tiny.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:44
 */
public class UrlResource implements Resource {

    private final URL url;

    UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputSteam() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}