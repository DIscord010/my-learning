package club.csiqu.basis.io.socket.http;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class HttpServerMain {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.await();
    }
}