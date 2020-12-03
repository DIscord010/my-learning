package club.csiqu.learn.basis;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @author Siqu Chen 2020/11/26
 * @since 1.0.0
 */
public class FalseSharingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(FalseSharingApplication.class);

    private static final int NUM_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        ValuePadding[] valuePaddings = new ValuePadding[NUM_THREADS];
        ValueNoPadding[] valueNoPaddings = new ValueNoPadding[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            valuePaddings[i] = new ValuePadding();
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            valueNoPaddings[i] = new ValueNoPadding();
        }
        // init threads
        Thread[] noPaddingThreads = new Thread[NUM_THREADS];
        Thread[] paddingThread = new Thread[NUM_THREADS];
        CountDownLatch noPaddingLatch = new CountDownLatch(NUM_THREADS);
        CountDownLatch paddingLatch = new CountDownLatch(NUM_THREADS);
        for (int i = 0; i < noPaddingThreads.length; i++) {
            final int index = i;
            noPaddingThreads[i] = new Thread(() -> {
                long count = 500L * 1000L * 100L;
                while (0 != --count) {
                    valueNoPaddings[index].value = 0L;
                }
                noPaddingLatch.countDown();
            });
        }
        for (int i = 0; i < paddingThread.length; i++) {
            final int index = i;
            paddingThread[i] = new Thread(() -> {
                long count = 500L * 1000L * 100L;
                do {
                    valuePaddings[index].value = 0L;
                } while (0 != --count);
                paddingLatch.countDown();
            });
        }
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (Thread t : noPaddingThreads) {
            t.start();
        }
        noPaddingLatch.await();
        LOGGER.info("No Paddings cost times: {}", stopwatch.stop());
        stopwatch.reset();
        stopwatch.start();
        for (Thread t : paddingThread) {
            t.start();
        }
        paddingLatch.await();
        LOGGER.info("Paddings cost times: {}", stopwatch.stop());

    }

    private static final class ValueNoPadding {

        protected volatile long value = 0L;
    }

    @SuppressWarnings("unused")
    private static final class ValuePadding {

        protected long p0, p1, p2, p3, p4, p5, p6;

        protected volatile long value = 0L;

        protected long p7, p9, p10, p11, p12, p13, p14;

        protected long p15;
    }
}