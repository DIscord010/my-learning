package club.csiqu.learn.framework.spring.aop.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siqu Chen 2020/8/13
 * @since 1.0
 */
public class SpringAdviceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringAdviceApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-aop.xml");
        Customer customer = (Customer) context.getBean("customerProxy");
        LOGGER.info("Customer name: {}", customer.getName());
    }
}