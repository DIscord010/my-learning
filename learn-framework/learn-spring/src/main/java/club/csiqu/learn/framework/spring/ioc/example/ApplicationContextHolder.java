package club.csiqu.learn.framework.spring.ioc.example;

import club.csiqu.learn.framework.spring.ioc.example.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siqu Chen 2020/6/15
 * @since 1.0
 */
public class ApplicationContextHolder {

    public static final ApplicationContext XML_CONTEXT;

    public static final ApplicationContext ANNOTATION_CONTEXT;

    public static final ApplicationContext CONFIG_CONTEXT;

    static {
        // 加载 XML文件的方式进行初始化上下文
        XML_CONTEXT = new ClassPathXmlApplicationContext("/spring/ioc/example/spring-ioc.xml");
        // 通过扫描路径进行初始化上下文
        ANNOTATION_CONTEXT =
                new AnnotationConfigApplicationContext("club.csiqu.learn.framework.spring.ioc.example.service");
        // 加载 Java配置类的方式初始化上下文
        CONFIG_CONTEXT = new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    private ApplicationContextHolder() {}
}