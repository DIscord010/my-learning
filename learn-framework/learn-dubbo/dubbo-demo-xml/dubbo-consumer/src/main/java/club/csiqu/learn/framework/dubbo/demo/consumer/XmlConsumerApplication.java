package club.csiqu.learn.framework.dubbo.demo.consumer;

import club.csiqu.learn.framework.dubbo.service.HelloService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0
 */
public class XmlConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlConsumerApplication.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("spring/dubbo/demo/consumer.xml");
        context.start();
        // 获取远程服务代理
        HelloService demoService = (HelloService) context.getBean("helloService");
        // 执行远程方法
        RpcContext.getContext().setAttachment("param", "test");
        String result = demoService.sayHello("world");
        // 显示调用结果
        LOGGER.info("service result: {}", result);
    }
}