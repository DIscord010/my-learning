package club.csiqu.learn.framework.rpc.tiny.proxy.service.impl;

import club.csiqu.learn.framework.rpc.tiny.proxy.bean.Person;
import club.csiqu.learn.framework.rpc.tiny.proxy.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:44
 */
@SuppressWarnings("unused")
public class HelloServiceImpl implements HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(Person person) {
        String result = "hello, " + person.getName();
        LOGGER.info("调用sayHello()方法：{}", result);
        return result;
    }
}