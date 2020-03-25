package club.csiqu.framework.dubbo.demo.service.impl;

import club.csiqu.framework.dubbo.service.HelloService;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0.0
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}