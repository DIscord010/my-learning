package club.csiqu.framework.spring.demo.ioc;

import org.springframework.stereotype.Component;

/**
 * @author chensiqu
 * @since 2019/3/18 10:33
 */
@Component
public class AutumnHelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello() {
        System.out.println("Autumn Say Hello");
    }
}