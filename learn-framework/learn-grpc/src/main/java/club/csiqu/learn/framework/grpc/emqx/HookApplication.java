package club.csiqu.learn.framework.grpc.emqx;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Siqu Chen 2023/3/13
 * @since 1.0
 */
public class HookApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HookApplication.class);

    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException, InterruptedException {
        final Server server = ServerBuilder.forPort(PORT)
                .addService(new HookProviderImpl())
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            LOGGER.info("*** shutting down gRPC server since JVM is shutting down");
            try {
                if (server != null) {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                }
            } catch (InterruptedException e) {
                LOGGER.error("Server shut down interrupt: ", e);
                Thread.currentThread().interrupt();
            }
            LOGGER.info("*** server shut down");
        }));
        server.awaitTermination();
    }
}
