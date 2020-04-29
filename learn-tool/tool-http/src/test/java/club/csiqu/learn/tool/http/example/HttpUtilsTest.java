package club.csiqu.learn.tool.http.example;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 比较每次都新建一个 {@link HttpClient}实例对象进行发送请求（每次请求都新建并关闭连接），
 * 与复用一个 {@link HttpClient}实例对象所花费的时间代价（连接复用）。
 * 排除初始化的时间，基本上未经过优化的时间花费为优化后的 3~4倍。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/25 14:31
 */
public class HttpUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtilsTest.class);

    private static final String GET_URL = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=17705911650";

    private static final String POST_URL = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";

    @Test
    public void testHttpUtils() {
        NameValuePair pair = new BasicNameValuePair("tel", "17705911650");
        List<NameValuePair> params = new ArrayList<>(1);
        params.add(pair);
        String postResult = HttpUtils.doPost(POST_URL, null, params);
        String getResult = HttpUtils.doGet(GET_URL, null);
        Assertions.assertEquals(getResult, postResult);
    }

    @Test
    public void testTimeCost() throws IOException {
        String result0 = null;
        long beforeTimeOffset0 = System.currentTimeMillis();
        for (int i = 0; i <= 20; i++) {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet httpGet = new HttpGet(GET_URL);
                CloseableHttpResponse response = httpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                result0 = EntityUtils.toString(entity);
            }
        }
        long afterTimeOffset0 = System.currentTimeMillis();
        long costTime0 = afterTimeOffset0 - beforeTimeOffset0;
        LOGGER.info("20次请求(每次断开连接)耗时为：{} ms", costTime0);

        String result1 = null;
        long beforeTimeOffset1 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            result1 = HttpUtils.doGet(GET_URL, null);
        }
        long afterTimeOffset1 = System.currentTimeMillis();
        long costTime1 = afterTimeOffset1 - beforeTimeOffset1;
        LOGGER.info("20次请求耗时为：{} ms", costTime1);
        Assertions.assertTrue(costTime0 > costTime1);
        Assertions.assertEquals(result0, result1);
    }
}