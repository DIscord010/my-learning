package club.csiqu.learn.framework.spring.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siqu Chen 2020/2/19
 * @since 1.0.0
 */
public class SpringHandlerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/handler/spring-handler.xml");
        // 配置文件的方式进行注入
        User user = (User)context.getBean("user");
        System.out.println(user.getName());
    }
}