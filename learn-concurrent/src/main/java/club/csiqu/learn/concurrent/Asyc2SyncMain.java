package club.csiqu.learn.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author chensiqu 2020/1/2
 * @since 1.0.0
 */
public class Asyc2SyncMain {

    private static final Logger LOG = LoggerFactory.getLogger(Asyc2SyncMain.class);

    public static final ThreadFactory THREAD_NAME_FACTORY =
            new ThreadFactoryBuilder().setNameFormat("异步获取数据线程池:%d").build();

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            THREAD_NAME_FACTORY);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                LOG.info("线程休眠中断异常");
            }
            completableFuture.complete("complete");
        });
        LOG.info("结果为：{}", completableFuture.get());
    }
}