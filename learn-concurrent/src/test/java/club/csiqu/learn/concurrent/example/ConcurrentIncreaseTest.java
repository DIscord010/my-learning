package club.csiqu.learn.concurrent.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Siqu Chen 2020/7/29
 * @since 1.0
 */
class ConcurrentIncreaseTest {

    private final ConcurrentIncrease concurrentIncrease = new ConcurrentIncrease();

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    void testIncrease() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    concurrentIncrease.increaseWithLock();
                    concurrentIncrease.increaseWithAtomic();
                    concurrentIncrease.increase();
                }
                latch.countDown();
            }));
        }
        latch.await();
        Assertions.assertEquals(100000, concurrentIncrease.getCount());
        Assertions.assertEquals(100000, concurrentIncrease.getIncrease());
        Assertions.assertEquals(100000, concurrentIncrease.getAtomicInteger().get());
    }
}