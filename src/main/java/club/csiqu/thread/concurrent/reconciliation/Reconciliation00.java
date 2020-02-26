package club.csiqu.thread.concurrent.reconciliation;

/**
 * 模拟对账系统
 * <p>
 * 效率低下，在一个单线程中循环查询订单、派送单、执行对账并将差异写入差异库。
 *
 * @author chensiqu
 * @since 2019/7/4 16:37
 */
public class Reconciliation00 implements Reconciliation {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 对账
     */
    @Override
    public void reconciliation() {
        String pos = orderService.getOrders();
        String dos = orderService.getDeliveryOrders();
        if (!orderService.check(pos, dos)) {
            orderService.save("different");
        }
    }
}