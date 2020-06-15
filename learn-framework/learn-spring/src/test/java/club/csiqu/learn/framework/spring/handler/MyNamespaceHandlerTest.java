package club.csiqu.learn.framework.spring.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siqu Chen 2020/6/15
 * @since 1.0.0
 */
class MyNamespaceHandlerTest {

    @Test
    void testSpringHandler() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/handler/spring-handler.xml");
        // 配置文件的方式进行注入
        User user = (User)context.getBean("user");
        Assertions.assertEquals("chensiqu", user.getName());
    }
}