package club.csiqu.tool.http.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 比较每次都新建一个 {@link HttpClient}实例对象进行发送请求（每次请求都新建并关闭连接），
 * 与复用一个 {@link HttpClient}实例对象所花费的时间代价（复用一个连接）。
 * 排除初始化的时间，基本上未经过优化的时间花费为优化后的 3~4倍。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/25 14:31
 */
public class HttpUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtilsTest.class);

    private static final String URL = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=17705911650";

    @Test
    public void traditionHttpTest() throws IOException {
        long beforeTimeOffset = System.currentTimeMillis();
        for (int i = 0; i <= 5; i++) {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet httpGet = new HttpGet(URL);
                CloseableHttpResponse response = httpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                LOGGER.info(EntityUtils.toString(entity));
            }
        }
        long afterTimeOffset = System.currentTimeMillis();
        LOGGER.info("5次请求耗时为：{} ms", afterTimeOffset - beforeTimeOffset);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void httpUtilTest() {
        // 先进行初始化
        HttpClientHolder.getHttpClient();
        long beforeTimeOffset = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            LOGGER.info(HttpUtils.doGet(URL, null));
        }
        long afterTimeOffset = System.currentTimeMillis();
        LOGGER.info("5次请求耗时为：{} ms", afterTimeOffset - beforeTimeOffset);
    }
}