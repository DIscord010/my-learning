package club.csiqu.framework.spring.demo.ioc;

/**
 * @author chensiqu
 * @since 2019/3/18 10:01
 */
public class SpringHelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello() {
        System.out.println("Spring Say Hello");
    }
}