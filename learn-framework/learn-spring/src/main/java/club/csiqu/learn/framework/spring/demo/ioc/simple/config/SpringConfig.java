package club.csiqu.learn.framework.spring.demo.ioc.simple.config;

import club.csiqu.learn.framework.spring.demo.ioc.simple.service.HelloWorldService;
import club.csiqu.learn.framework.spring.demo.ioc.simple.service.HelloWorld;
import club.csiqu.learn.framework.spring.demo.ioc.simple.service.impl.AutumnHelloWorldImpl;
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