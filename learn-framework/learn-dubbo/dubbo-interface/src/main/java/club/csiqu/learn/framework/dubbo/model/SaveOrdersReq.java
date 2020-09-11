package club.csiqu.learn.framework.dubbo.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Siqu Chen 2020/9/11
 * @since 1.0
 */
public class SaveOrdersReq implements Serializable {

    private List<AddOrderInfoReq> orders;

    public List<AddOrderInfoReq> getOrders() {
        return orders;
    }

    public void setOrders(List<AddOrderInfoReq> orders) {
        this.orders = orders;
    }
}