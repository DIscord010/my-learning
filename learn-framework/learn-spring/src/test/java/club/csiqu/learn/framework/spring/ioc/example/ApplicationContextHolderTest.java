package club.csiqu.learn.framework.spring.ioc.example;

import club.csiqu.learn.framework.spring.ioc.example.service.HelloWorld;
import club.csiqu.learn.framework.spring.ioc.example.service.HelloWorldService;
import club.csiqu.learn.framework.spring.ioc.example.service.LazyService;
import club.csiqu.learn.framework.spring.ioc.example.service.SayGoodService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/6/15
 * @since 1.0
 */
class ApplicationContextHolderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextHolderTest.class);

    @Test
    void testXmlAutowire() {
        HelloWorldService service = (HelloWorldService) ApplicationContextHolder.XML_CONTEXT.
                getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        Assertions.assertEquals("Spring Say Hello", helloWorld.sayHello());
    }

    @Test
    void testAnnotationAutowire() {
        HelloWorldService service = (HelloWorldService) ApplicationContextHolder.ANNOTATION_CONTEXT.
                getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        Assertions.assertEquals("Summer Say Hello", helloWorld.sayHello());
    }

    @Test
    void testConfigAutowire() {
        HelloWorldService service = (HelloWorldService) ApplicationContextHolder.CONFIG_CONTEXT.
                getBean("helloWorldService");
        HelloWorld helloWorld = service.getHelloWorld();
        Assertions.assertEquals("Autumn Say Hello", helloWorld.sayHello());
    }

    @Test
    void testLazyAnnotationAutowire() {
        LazyService service = (LazyService) ApplicationContextHolder.ANNOTATION_CONTEXT.
                getBean("lazyService");
        SayGoodService sayGoodService = service.getSayGoodService();
        SayGoodService lazy = service.getLazySayGoodService();
        LOGGER.info("SayGoodService class: {}", sayGoodService.getClass());
        LOGGER.info("Lazy SayGoodService class: {}", lazy.getClass());
        Assertions.assertNotEquals(sayGoodService.getClass().getName(), lazy.getClass().getName());
        Assertions.assertEquals(sayGoodService.sayGood(), lazy.sayGood());
    }
}