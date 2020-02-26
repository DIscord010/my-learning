package club.csiqu.tool.http.example;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/19 15:21
 */
public class HttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    private HttpUtils() {
    }

    public static String doPost(String url, List<Header> headers, List<NameValuePair> params) {
        HttpPost httpPost = new HttpPost(url);
        if (headers != null && headers.size() > 0) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
        }
        if (params != null && params.size() > 0) {
            httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
        }
        try (CloseableHttpResponse response = HttpClientHolder.getHttpClient().execute(httpPost)) {
            if (response.getStatusLine() == null) {
                return null;
            }
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } else {
                LOGGER.warn("POST请求响应状态码异常，URL为 {}，状态码为 {}", url, statusCode);
            }
        } catch (IOException e) {
            LOGGER.warn("POST请求IO异常：{}", e.getMessage());
        }
        return null;
    }

    /**
     * 发送 get请求
     *
     * @param url     请求地址，包含参数（get请求参数包含在 url中，调用方自行拼接）
     * @param headers 头部参数
     * @return 如果出现异常则返回 {@code null}
     */
    public static String doGet(String url, List<Header> headers) {
        HttpGet httpGet = new HttpGet(url);
        if (headers != null && headers.size() > 0) {
            for (Header header : headers) {
                httpGet.addHeader(header);
            }
        }
        try (CloseableHttpResponse response = HttpClientHolder.getHttpClient().execute(httpGet)) {
            if (response.getStatusLine() == null) {
                return null;
            }
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } else {
                LOGGER.warn("GET请求响应状态码异常，URL为 {}，状态码为 {}", url, statusCode);
            }
        } catch (IOException e) {
            LOGGER.warn("GET请求IO异常：{}", e.getMessage());
        }
        return null;
    }
}