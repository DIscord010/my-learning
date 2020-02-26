package club.csiqu.framework.spring.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring/spring-aop.xml");
        CustomerService customerService = (CustomerService) context.getBean("customerServiceProxy");
        customerService.printName();
        customerService.printUrl();
    }
}