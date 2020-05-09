package club.csiqu.learn.tool.apache.http;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

/**
 * httpclient重试机制研究（version：4.5.10）：
 * <p>
 * 默认存在重试机制：
 * 但是 InterruptedIOException, ConnectException, UnknownHostException, SSLException四种异常不进行重试。
 * 则连接超时（ConnectTimeout，也可以说是写超时）和响应超时(SocketTimeout，读取超时)以及因为网络抖动而导致的连接失败（connectException）都是不进行重试的。
 * 默认重试三次，且携带实体（A request with an entity）的请求不进行重试，即 post、put请求不进行重试。
 * 可以自定实现 {@link  HttpRequestRetryHandler}接口来自定义重试规则。
 * 且如果使用的是同一个 httpclient的实例，那么相同域名下的 URL就会共用同一个连接。
 * 默认的连接配置管理器（默认的每个路由的最大连接数（maxPerRoute）为 2，连接总数（maxTotal）为 20）。
 * <p>
 * 如何设置合理参数：
 * <p>
 * 1、连接数相关参数：
 * maxTotal-连接总数、maxPerRoute-路由最大连接数需要根据服务端和客户端的 qps进行判断设定。
 * 2、超时时间相关参数：
 * connectTimeout（连接超时时间）根据网络情况设定，可以设定为 2s。
 * socketTimeout（读超时时间，等待数据超时时间）可以根据具体业务，以及正常平均响应时间设定。如平均响应为 1s，则可以设定为 2s。
 * connectionRequestTimeout（从池中获取连接超时时间）建议设置 500ms即可，不要设置太大，
 * 使连接池连接不够时不用等待太久去获取连接，不要让大量请求堆积在获取连接处，尽快抛出异常，发现问题。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/10 17:50
 */
public class HttpClientMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientMain.class);

    public static void main(String[] args) throws IOException {

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(retryHandler())
                .build()) {
            HttpPost httpPost = new HttpPost("http://127.0.0.1:123");
            LOGGER.info("Executing request: {}", httpPost.getRequestLine());
            httpClient.execute(httpPost);
            LOGGER.info("----------------------");
            LOGGER.info("Request finish");
        }
    }

    private static HttpRequestRetryHandler retryHandler() {

        return (exception, executionCount, context) -> {

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("try request: {}", executionCount);
            }

            if (executionCount >= 3) {
                // Do not retry if over max retry count
                return false;
            }
            if (exception instanceof InterruptedIOException) {
                // Timeout
                return false;
            }
            if (exception instanceof UnknownHostException) {
                // Unknown host
                return false;
            }
            if (exception instanceof SSLException) {
                // SSL handshake exception
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            // Retry if the request is considered idempotent
            return !(request instanceof HttpEntityEnclosingRequest);
        };
    }
}