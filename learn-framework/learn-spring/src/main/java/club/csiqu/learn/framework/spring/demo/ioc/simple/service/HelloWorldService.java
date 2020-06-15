package club.csiqu.learn.framework.spring.demo.ioc.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chensiqu
 * @since 2019/3/18 10:32
 */
@Component
public class HelloWorldService {

    private HelloWorld helloWorld;

    public HelloWorldService() {}

    @Autowired
    public HelloWorldService(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
}