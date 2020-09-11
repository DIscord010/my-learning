package club.csiqu.learn.framework.dubbo.demo.service.impl;

import club.csiqu.learn.framework.dubbo.model.BaseReq;
import club.csiqu.learn.framework.dubbo.model.SaveOrdersReq;
import club.csiqu.learn.framework.dubbo.service.HelloService;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String saveOrderList(BaseReq<SaveOrdersReq> req) {
        return req.getData().getOrders().get(0).getOrder();
    }
}