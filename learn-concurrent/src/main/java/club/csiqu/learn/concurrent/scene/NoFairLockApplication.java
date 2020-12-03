package club.csiqu.learn.concurrent.scene;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁性能对比。
 *
 * @author Siqu Chen 2020/12/3
 * @since 1.0.0
 */
public class NoFairLockApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoFairLockApplication.class);

    /** 线程数 */
    private static final int THREAD_SIZE = 50;

    /** 循环次数 */
    private static final int LOOP_NUMBER = 10000;

    /** 非公平锁 */
    private static final Lock UNFAIR_LOCK = new ReentrantLock(false);

    /** 公平锁 */
    private static final Lock FAIR_LOCK = new ReentrantLock(true);

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        count(UNFAIR_LOCK);
        LOGGER.info("NnFair Lock Count cost times: {}", stopwatch.stop());

        stopwatch.reset();
        stopwatch.start();
        count(FAIR_LOCK);
        LOGGER.info("Fair Lock Count cost times: {}", stopwatch.stop());
        LOGGER.info("Count result: {}", count);
    }

    private static void count(Lock lock) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_SIZE);
        for (int i = 0; i < THREAD_SIZE; i++) {
            new Thread(() -> {
                for (int j = 0; j < LOOP_NUMBER; j++) {
                    lock.lock();
                    try {
                        count++;
                    } finally {
                        lock.unlock();
                    }
                }
                latch.countDown();
            }).start();
        }
        latch.await();
    }
}