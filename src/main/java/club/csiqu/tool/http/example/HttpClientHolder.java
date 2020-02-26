package club.csiqu.tool.http.example;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/19 15:21
 */
class HttpClientHolder {

    /** 连接池最大连接数 */
    private static final int POOL_MAX_TOTAL = 200;

    /** 单路由最大连接数 */
    private static final int POOL_MAX_PRE_ROUTE = 200;

    /** 连接超时时间 */
    private static final int CONNECT_TIMEOUT = 500;

    /** 从连接池中获取连接超时时间 */
    private static final int CONNECT_REQUEST_TIMEOUT = 500;

    /** 响应超时时间 */
    private static final int SOCKET_TIMEOUT = 2000;

    private static CloseableHttpClient httpClient;

    static {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(registry);
        manager.setMaxTotal(POOL_MAX_TOTAL);
        manager.setDefaultMaxPerRoute(POOL_MAX_PRE_ROUTE);
        RequestConfig requestConfig = RequestConfig.custom()
                // 连接超时时间（写入数据时间）
                .setConnectTimeout(CONNECT_TIMEOUT)
                // 读取超时时间（获取响应数据时间）
                .setSocketTimeout(SOCKET_TIMEOUT)
                // 从连接池中获取连接等待超时时间
                .setConnectionRequestTimeout(CONNECT_REQUEST_TIMEOUT)
                .build();
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClient = httpClientBuilder
                .setConnectionManager(manager)
                .setDefaultRequestConfig(requestConfig)
                .build();
        IdleConnectionMonitorThread idleThread = new IdleConnectionMonitorThread(manager);
        idleThread.start();
    }

    static CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * 失效连接处理线程，因为默认的处理策略是懒惰清理：
     * 在获取连接时判断是否失效再进行关闭（失效指服务端关闭了连接但是客户端因为没有使用没有进行关闭）（被动关闭）。
     * 有可能造成某一连接已失效但是 httpClient始终未关闭而占用连接池名额的情况。官方给出的建议即引入清理线程。
     */
    private static class IdleConnectionMonitorThread extends Thread {

        private final HttpClientConnectionManager manager;

        IdleConnectionMonitorThread(HttpClientConnectionManager manager) {
            this.manager = manager;
            this.setName("httpClient-idle-connection-thread");
            setDaemon(true);
        }

        @Override
        public void run() {
            // 每间隔 2秒钟进行连接清理
            try {
                this.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 关闭过期的连接（服务端会返回约定的过期时间，如果没有返回默认的策略设置为永久有效）
            manager.closeExpiredConnections();
            // 关闭 30秒内不活动的连接（空闲连接）
            manager.closeIdleConnections(30, TimeUnit.SECONDS);
        }
    }
}