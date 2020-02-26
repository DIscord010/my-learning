package club.csiqu.framework.spring.demo.ioc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SpringConfig {

    @Bean
    public HelloWorld springHelloWordImpl() {
        return new SpringHelloWorldImpl();
    }

    @Bean
    public HelloWorld summerHelloWorldImpl() {
        return new SummerHelloWorldImpl();
    }

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }
}


