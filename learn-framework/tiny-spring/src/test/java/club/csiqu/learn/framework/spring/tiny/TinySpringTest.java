package club.csiqu.learn.framework.spring.tiny;

import club.csiqu.learn.framework.spring.tiny.context.ApplicationContext;
import club.csiqu.learn.framework.spring.tiny.context.ClassPathXmlApplicationContext;
import club.csiqu.learn.framework.spring.tiny.service.HelloService;
import org.junit.jupiter.api.Test;


/**
 * 根据 github上 tiny-spring项目学习 Spring IoC和 Spring AOP原理。
 *
 * @author chensiqu [540498860@qq.com]
 * @see <a href="https://github.com/code4craft/tiny-spring">tiny-spring</a>
 * @since 2019/8/20 10:00
 */
public class TinySpringTest {

    @Test
    public void applicationContextTest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/tiny/tiny-spring-ioc.xml");
        HelloService helloService = (HelloService)applicationContext.getBean("helloService");
        helloService.hello();
    }

    @Test
    public void aopTest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/tiny/tiny-spring-aop.xml");
        HelloService helloService = (HelloService)applicationContext.getBean("hello");
        helloService.hello();
    }
}