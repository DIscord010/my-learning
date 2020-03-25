package club.csiqu.learn.concurrent.reconciliation;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chensiqu
 * @since 2019/7/7 22:22
 */
public class Reconciliation11 implements Reconciliation {

    private OrderService orderService = new OrderServiceImpl();

    private Vector<String> pos = new Vector<>();

    private Vector<String> dos = new Vector<>();

    private static final ThreadFactory RECONCILIATION_THREAD_NAME_FACTORY =
            new ThreadFactoryBuilder().setNameFormat("对账服务线程池:%d").build();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            RECONCILIATION_THREAD_NAME_FACTORY);

    private static final ThreadFactory ORDER_THREAD_NAME_FACTORY =
            new ThreadFactoryBuilder().setNameFormat("获取订单信息线程池:%d").build();

    private ThreadPoolExecutor orderExecutor = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            ORDER_THREAD_NAME_FACTORY);

    private static ThreadFactory DELIVERY_THREAD_NAME_FACTORY =
            new ThreadFactoryBuilder().setNameFormat("获取派送单信息线程池:%d").build();

    private ThreadPoolExecutor deliveryOrderExecutor = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            DELIVERY_THREAD_NAME_FACTORY);


    private final CyclicBarrier barrier = new CyclicBarrier(2, () ->
            executor.execute(this::check));

    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 这里有个问题，就是这个方法只能被单线程执行
     */
    @Override
    public void reconciliation() {

        // 新建线程
        orderExecutor.execute(() -> {
            atomicInteger.getAndIncrement();
            pos.add(orderService.getOrders());
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        // 新建线程
        deliveryOrderExecutor.execute(() -> {
            atomicInteger.getAndIncrement();
            dos.add(orderService.getDeliveryOrders());
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
    }

    private void check() {
        String p = pos.remove(0);
        String d = dos.remove(0);
        atomicInteger.getAndIncrement();
        if (!orderService.check(p, d)) {
            orderService.save("different");
        }
    }
}