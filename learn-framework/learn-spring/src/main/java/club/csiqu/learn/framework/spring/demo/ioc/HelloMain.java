package club.csiqu.learn.framework.spring.demo.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {


    /**
     * springIOC通过三种方式进行注入
     * <p>
     * 通过 auto-wiring功能装配，
     * 配置文件中：在 bean设置 property属性进行装配。
     *
     * @param args 主函数入口参数
     */
    public static void main(String[] args) {
        // 通过 xml配置文件获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/spring-ioc.xml");
        // 配置文件的方式进行注入
        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        helloWorld.sayHello();
        // 注解的方式进行注入
        HelloWorldServiceByAnnotations serviceByAnnotations =
                (HelloWorldServiceByAnnotations) context.getBean("helloWorldServiceByAnnotations");
        HelloWorld autumnHelloWorld = serviceByAnnotations.getHelloWorld();
        autumnHelloWorld.sayHello();
        // 通过配置类获取上下文
        ApplicationContext contextByConfig =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        SummerHelloWorldImpl summerHelloWorld =
                (SummerHelloWorldImpl) contextByConfig.getBean(
                        "summerHelloWorldImpl");
        summerHelloWorld.sayHello();
    }
}