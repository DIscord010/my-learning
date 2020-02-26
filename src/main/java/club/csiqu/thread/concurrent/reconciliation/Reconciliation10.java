package club.csiqu.thread.concurrent.reconciliation;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 线程切换也会影响效率。
 *
 * @author chensiqu
 * @since 2019/7/5 16:01
 */
public class Reconciliation10 implements Reconciliation {

    private OrderService orderService = new OrderServiceImpl();

    public static final ThreadFactory THREAD_NAME_FACTORY =
            new ThreadFactoryBuilder().setNameFormat("对账服务线程池:%d").build();

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            2,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            THREAD_NAME_FACTORY);

    @Override
    public void reconciliation() throws InterruptedException {

        String[] strs = new String[2];
        // 使用 CountDownlatch来使主线程同步
        CountDownLatch downLatch = new CountDownLatch(2);
        executor.execute(() -> {
            strs[0] = orderService.getOrders();
            downLatch.countDown();
        });
        executor.execute(() -> {
            strs[1] = orderService.getDeliveryOrders();
            downLatch.countDown();
        });
        downLatch.await();
        if (!orderService.check(strs[0], strs[1])) {
            orderService.save("different");
        }

    }
}