package club.csiqu.learn.framework.dubbo.service;

import club.csiqu.learn.framework.dubbo.model.BaseReq;
import club.csiqu.learn.framework.dubbo.model.SaveOrdersReq;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0
 */
public interface HelloService {

    /**
     * sayHello
     *
     * @param name name
     * @return {@link String}
     */
    String sayHello(String name);


    String saveOrderList(BaseReq<SaveOrdersReq> req);
}