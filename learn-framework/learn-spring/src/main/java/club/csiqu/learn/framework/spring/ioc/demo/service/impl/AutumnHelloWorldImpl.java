package club.csiqu.learn.framework.spring.ioc.demo.service.impl;

import club.csiqu.learn.framework.spring.ioc.demo.service.HelloWorld;

/**
 * @author chensiqu
 * @since 2019/3/18 10:33
 */
public class AutumnHelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello() {
        return "Autumn Say Hello";
    }
}