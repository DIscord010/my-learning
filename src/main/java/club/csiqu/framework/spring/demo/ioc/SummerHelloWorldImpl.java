package club.csiqu.framework.spring.demo.ioc;

/**
 * @author chensiqu
 * @since 2019/3/18 10:03
 */
public class SummerHelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello() {
        System.out.println("Summer Say Hello");
    }
}