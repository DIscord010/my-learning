package club.csiqu.framework.dubbo.my.rpc.provider;

import club.csiqu.framework.dubbo.my.rpc.api.bean.Person;
import club.csiqu.framework.dubbo.my.rpc.api.service.HelloService;
import club.csiqu.framework.dubbo.my.rpc.consumer.proxy.RpcProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/3/10
 * @since 1.0.0
 */
class RpcServerTest {

   @BeforeEach
    void init() {
        RpcServer.SERVER_LIST.put("club.csiqu.framework.dubbo.my.rpc.api.service.HelloService",
                "club.csiqu.framework.dubbo.my.rpc.provider.service.impl.HelloServiceImpl");
        new RpcServer().service();
    }

    @Test
    public void testService() {
        HelloService helloService = new RpcProxy().getObject(HelloService.class);
        Assertions.assertEquals(helloService.sayHello(new Person("chensiqu")), "hello, chensiqu");
    }
}