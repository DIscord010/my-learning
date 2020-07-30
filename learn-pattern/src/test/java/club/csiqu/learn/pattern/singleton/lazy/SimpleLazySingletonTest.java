package club.csiqu.learn.pattern.singleton.lazy;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0
 */
class SimpleLazySingletonTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleLazySingletonTest.class);

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
        HashSet<SimpleLazySingleton> hashSet = new HashSet<>(8);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    LOGGER.warn("CountDownLatch InterruptedException:", e);
                }
                hashSet.add(SimpleLazySingleton.getInstance());
                endLatch.countDown();
            });
        }
        // 100个线程同时执行
        latch.countDown();
        // 等待工作完成
        endLatch.await();
        // 如果线程安全，只会产生一个单例对象
        Assertions.assertTrue(hashSet.size() > 1);
        // 产生多个单例对象
        for (SimpleLazySingleton simpleLazySingleton : hashSet) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("{} : {}", simpleLazySingleton.toString(), simpleLazySingleton.sayHello());
            }
        }
    }
}