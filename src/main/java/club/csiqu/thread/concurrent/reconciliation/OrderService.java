package club.csiqu.thread.concurrent.reconciliation;

/**
 * 模拟订单系统
 * <p>
 * 可以进行查询订单、查询派送单、进行对账、保存差异进入差异库。
 *
 * @author chensiqu
 * @since 2019/7/4 16:38
 */
public interface OrderService {

    /**
     * 获取订单信息
     *
     * @return 订单号
     */
    String getOrders();

    /**
     * 获取派送单信息
     *
     * @return 派送单号
     */
    String getDeliveryOrders();

    /**
     * 差异比对
     *
     * @param pOrders 订单号
     * @param dOrders 派送单号
     * @return {@code true}如果存在差异
     */
    Boolean check(String pOrders, String dOrders);

    /**
     * 保存差异进差异库
     *
     * @param differernt 差异信息
     */
    void save(String differernt);
}