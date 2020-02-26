package club.csiqu.framework.dubbo.demo.consumer;

import club.csiqu.framework.dubbo.demo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0.0
 */
public class ConsumerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("spring/dubbo/demo/consumer.xml");
        context.start();
        // 获取远程服务代理
        HelloService demoService = (HelloService)context.getBean("helloService");
        // 执行远程方法
        String hello = demoService.sayHello("world");
        // 显示调用结果
        System.out.println(hello);
    }
}