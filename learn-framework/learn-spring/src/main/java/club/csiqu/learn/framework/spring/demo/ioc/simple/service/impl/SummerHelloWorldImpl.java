package club.csiqu.learn.framework.spring.demo.ioc.simple.service.impl;

import club.csiqu.learn.framework.spring.demo.ioc.simple.service.HelloWorld;
import org.springframework.stereotype.Component;

/**
 * @author chensiqu
 * @since 2019/3/18 10:03
 */
@Component
public class SummerHelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello() {
        return "Summer Say Hello";
    }
}