package club.csiqu.learn.framework.spring.demo.ioc.simple.service.impl;

import club.csiqu.learn.framework.spring.demo.ioc.simple.service.HelloWorld;

/**
 * @author chensiqu
 * @since 2019/3/18 10:01
 */
public class SpringHelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello() {
        return "Spring Say Hello";
    }
}