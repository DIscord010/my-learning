package club.csiqu.learn.framework.rpc.tiny.proxy;

import club.csiqu.learn.framework.rpc.tiny.proxy.bean.Person;
import club.csiqu.learn.framework.rpc.tiny.proxy.service.HelloService;
import club.csiqu.learn.framework.rpc.tiny.server.RpcServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Siqu Chen 2020/4/14
 * @since 1.0.0
 */
class RpcProxyTest {

    @BeforeEach
    void init() throws IOException {
        RpcServer rpcServer = new RpcServer();
        rpcServer.addServer("club.csiqu.learn.framework.rpc.tiny.proxy.service.HelloService",
                "club.csiqu.learn.framework.rpc.tiny.proxy.service.impl.HelloServiceImpl");
        rpcServer.service();
    }

    @Test
    public void testService() {
        HelloService helloService = new RpcProxy().getObject(HelloService.class);
        Assertions.assertEquals("hello, chensiqu", helloService.sayHello(new Person("chensiqu")));
    }
}