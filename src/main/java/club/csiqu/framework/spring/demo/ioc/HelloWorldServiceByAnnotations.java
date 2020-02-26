package club.csiqu.framework.spring.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author chensiqu
 * @since 2019/3/18 10:32
 */
@Component
public class HelloWorldServiceByAnnotations {

    private final HelloWorld helloWorld;

    @Autowired
    public HelloWorldServiceByAnnotations(@Qualifier("autumnHelloWorldImpl") HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
}