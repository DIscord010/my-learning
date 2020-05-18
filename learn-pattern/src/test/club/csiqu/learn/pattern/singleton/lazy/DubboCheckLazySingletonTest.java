package club.csiqu.learn.pattern.singleton.lazy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
class DubboCheckLazySingletonTest {

    @Test
    void testGetInstance() {
        DubboCheckLazySingleton instance0 = DubboCheckLazySingleton.getInstance();
        Assertions.assertEquals("hello", instance0.sayHello());
        DubboCheckLazySingleton instance1 = DubboCheckLazySingleton.getInstance();
        Assertions.assertEquals(instance0, instance1);
    }

}