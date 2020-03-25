package club.csiqu.learn.framework.spring.demo.ioc;

/**
 * @author chensiqu
 * @since 2019/3/18 10:05
 */
public class HelloWorldService {

    private HelloWorld helloWorld;

    HelloWorldService() {

    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
}