package club.csiqu.learn.framework.spring.ioc.example.config;

import club.csiqu.learn.framework.spring.ioc.example.service.HelloWorldService;
import club.csiqu.learn.framework.spring.ioc.example.service.HelloWorld;
import club.csiqu.learn.framework.spring.ioc.example.service.impl.AutumnHelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Siqu Chen
 */
@Configuration
public class SpringConfig {

    @Bean
    public HelloWorld autumnHelloWorldImpl() {
        return new AutumnHelloWorldImpl();
    }

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldService(autumnHelloWorldImpl());
    }
}