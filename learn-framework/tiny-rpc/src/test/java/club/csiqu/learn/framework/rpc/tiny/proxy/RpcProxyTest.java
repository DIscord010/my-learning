package club.csiqu.learn.framework.rpc.tiny.proxy;

import club.csiqu.learn.framework.rpc.tiny.proxy.bean.Person;
import club.csiqu.learn.framework.rpc.tiny.proxy.service.HelloService;
import club.csiqu.learn.framework.rpc.tiny.server.RpcServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/4/14
 * @since 1.0.0
 */
class RpcProxyTest {

    @BeforeEach
    void init() {
        RpcServer.SERVER_LIST.put("club.csiqu.learn.framework.rpc.tiny.proxy.service.HelloService",
                "club.csiqu.learn.framework.rpc.tiny.proxy.service.impl.HelloServiceImpl");
        new RpcServer().service();
    }

    @Test
    public void testService() {
        HelloService helloService = new RpcProxy().getObject(HelloService.class);
        Assertions.assertEquals(helloService.sayHello(new Person("chensiqu")), "hello, chensiqu");
    }
}