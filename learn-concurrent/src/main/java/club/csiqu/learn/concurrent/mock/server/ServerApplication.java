package club.csiqu.learn.concurrent.mock.server;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class ServerApplication {

    public static void main(String[] args) {
        ConcurrentServer concurrentServer = new ConcurrentServer();
        concurrentServer.service();
    }
}