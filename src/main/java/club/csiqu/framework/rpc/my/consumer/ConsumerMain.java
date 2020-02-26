package club.csiqu.framework.rpc.my.consumer;

import club.csiqu.framework.rpc.my.api.bean.Person;
import club.csiqu.framework.rpc.my.api.service.HelloService;
import club.csiqu.framework.rpc.my.consumer.proxy.RpcProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单 RPC实现。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:51
 */
public class ConsumerMain {

    private static final Logger LOGGER  = LoggerFactory.getLogger(ConsumerMain.class);

    public static void main(String[] args) {
        HelloService helloService = new RpcProxy().getObject(HelloService.class);
        LOGGER.info(helloService.sayHello(new Person("chensiqu")));
        helloService.helloWorld();
    }
}