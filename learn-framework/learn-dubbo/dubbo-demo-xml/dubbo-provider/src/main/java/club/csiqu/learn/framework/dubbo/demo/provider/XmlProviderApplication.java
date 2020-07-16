package club.csiqu.learn.framework.dubbo.demo.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0.0
 */
public class XmlProviderApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlProviderApplication.class);

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("spring/dubbo/demo/provider/provider.xml");
        context.start();
        // 按任意键退出
        LOGGER.info("{}", System.in.read());
    }
}