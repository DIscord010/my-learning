package club.csiqu.learn.basis.io.net.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Siqu Chen 2020/5/12
 * @since 1.0
 */
class HttpServerTest {

    @BeforeAll
    static void initServer() throws IOException {
        new HttpServer(8003).service();
    }

    @Test
    void testHttpServer() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://127.0.0.1:8003/test");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            Assertions.assertEquals("<h1>File Not Found</h1>", EntityUtils.toString(entity));
        }
    }
}