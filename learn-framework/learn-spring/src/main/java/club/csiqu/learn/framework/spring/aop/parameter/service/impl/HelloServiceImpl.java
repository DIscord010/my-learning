package club.csiqu.learn.framework.spring.aop.parameter.service.impl;

import club.csiqu.learn.framework.spring.aop.parameter.annotation.ParameterHandler;
import club.csiqu.learn.framework.spring.aop.parameter.bean.Person;
import club.csiqu.learn.framework.spring.aop.parameter.service.HelloService;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:24
 */
public class HelloServiceImpl implements HelloService {

    @Override
    @ParameterHandler
    public void sayHello(Person person) {

        System.out.println(person.getName() + " say hello!");
    }
}