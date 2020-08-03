package club.csiqu.learn.concurrent.demo.lock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Siqu Chen 2020/8/3
 * @since 1.0
 */
class LockTest {

    private static int count = 0;

    Executor executor = Executors.newFixedThreadPool(2);

    @BeforeAll
    static void refreshCount() {
        count = 0;
    }

    @Test
    void testMyLock() throws InterruptedException {
        testLock(new MyLock());
    }

    @Test
    void testReentrantLock() throws InterruptedException {
        testLock(new ReentrantLock());
    }

    @Test
    void testNonReentrantLock() throws InterruptedException {
        testLock(new NonReentrantLock());
    }

    private void testLock(Lock lock) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable runnable = () -> {
            lock.lock();
            try {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
                countDownLatch.countDown();
            } finally {
                lock.unlock();
            }
        };
        executor.execute(runnable);
        executor.execute(runnable);
        countDownLatch.await();
        Assertions.assertEquals(20000, count);
    }
}