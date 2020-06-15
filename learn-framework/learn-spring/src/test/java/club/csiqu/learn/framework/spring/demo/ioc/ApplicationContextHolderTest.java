package club.csiqu.learn.framework.spring.demo.ioc;

import club.csiqu.learn.framework.spring.demo.ioc.simple.ApplicationContextHolder;
import club.csiqu.learn.framework.spring.demo.ioc.simple.service.HelloWorldService;
import club.csiqu.learn.framework.spring.demo.ioc.simple.service.HelloWorld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/6/15
 * @since 1.0.0
 */
class ApplicationContextHolderTest {

    @Test
    void testXmlAutowire() {
        HelloWorldService service = (HelloWorldService)ApplicationContextHolder.XML_CONTEXT.
                getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        Assertions.assertEquals("Spring Say Hello", helloWorld.sayHello());
    }

    @Test
    void testAnnotationAutowire() {
        HelloWorldService service = (HelloWorldService)ApplicationContextHolder.ANNOTATION_CONTEXT.
                getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        Assertions.assertEquals("Summer Say Hello", helloWorld.sayHello());
    }

    @Test
    void testConfigAutowire() {
        HelloWorldService service = (HelloWorldService)ApplicationContextHolder.CONFIG_CONTEXT.
                getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        Assertions.assertEquals("Autumn Say Hello", helloWorld.sayHello());
    }
}