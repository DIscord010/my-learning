package club.csiqu.learn.framework.spring.demo.aop.parameter;

import club.csiqu.learn.framework.spring.demo.aop.parameter.bean.Person;
import club.csiqu.learn.framework.spring.demo.aop.parameter.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:10
 */
public class ParameterTransformMain {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/spring-my-parameter.xml");
        HelloService helloService = (HelloService)context.getBean("sayHelloService");
        Person person = new Person("chen");
        helloService.sayHello(person);
    }
}