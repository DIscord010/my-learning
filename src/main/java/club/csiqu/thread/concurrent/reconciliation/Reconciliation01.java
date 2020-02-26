package club.csiqu.thread.concurrent.reconciliation;

/**
 * 创建两个线程进行获取订单和派送单，提高系统的效率。
 * 但是每次创建线程和销毁线程都耗费资源，导致效率更低。
 * 实际应用不能手动创建线程。
 *
 * @author chensiqu
 * @since 2019/7/4 17:28
 */
public class Reconciliation01 implements Reconciliation {

    private OrderService orderService = new OrderServiceImpl();

    @Override
    public void reconciliation() throws InterruptedException {
        String[] strs = new String[2];
        // 新建线程
        Thread t1 = new Thread(() ->
                strs[0] = orderService.getOrders());
        t1.start();
        // 新建线程
        Thread t2 = new Thread(() ->
                strs[1] = orderService.getDeliveryOrders());
        t2.start();

        // 等待两个线程完成工作
        t1.join();
        t2.join();

        if (!orderService.check(strs[0], strs[1])) {
            orderService.save("different");
        }
    }
}