package club.csiqu.learn.framework.dubbo.model;

import java.io.Serializable;

/**
 * @author Siqu Chen 2020/9/11
 * @since 1.0
 */
public class AddOrderInfoReq implements Serializable {

    private String order;

    public AddOrderInfoReq(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}