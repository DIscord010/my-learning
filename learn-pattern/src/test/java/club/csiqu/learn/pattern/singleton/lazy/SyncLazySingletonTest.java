package club.csiqu.learn.pattern.singleton.lazy;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0
 */
class SyncLazySingletonTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SyncLazySingletonTest.class);

    private final Executor executor = new ThreadPoolExecutor(
            100,
            100,
            5L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("echo-server-pool-%d").build());

    @Test
    void testGetInstance() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(100);
        Set<SyncLazySingleton> hashSet = Collections.synchronizedSet(new HashSet<>(8));
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    LOGGER.warn("CountDownLatch InterruptedException:", e);
                }
                hashSet.add(SyncLazySingleton.getInstance());
                endLatch.countDown();
            });
        }
        // 100个线程同时执行
        latch.countDown();
        // 等待工作完成
        endLatch.await();
        // 只会产生一个单例对象
        assertEquals(1, hashSet.size());
    }
}