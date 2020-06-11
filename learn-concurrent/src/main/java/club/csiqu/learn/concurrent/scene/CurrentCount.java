package club.csiqu.learn.concurrent.scene;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
public class CurrentCount {

    private final Executor executor = Executors.newFixedThreadPool(2);

    private static final int SIZE_10KK = 10000000;

    private long number = 0;

    /**
     * 两个线程并发执行 ++操作
     *
     * @throws InterruptedException 中断异常
     */
    public void currentAdd() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        // 创建两个线程执行 add10()方法
        executor.execute(() -> {
            add10k();
            countDownLatch.countDown();
        });
        executor.execute(() -> {
            add10k();
            countDownLatch.countDown();
        });
        countDownLatch.await();
    }

    public long getNumber() {
        return number;
    }

    private void add10k() {
        int index = 0;
        while (index++ < SIZE_10KK) {
            number += 1;
        }
    }
}