package club.csiqu.learn.framework.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0.0
 */
public class XmlProviderMain {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("spring/dubbo/demo/provider/provider.xml");
        context.start();
        // 按任意键退出
        System.out.println(System.in.read());
    }
}