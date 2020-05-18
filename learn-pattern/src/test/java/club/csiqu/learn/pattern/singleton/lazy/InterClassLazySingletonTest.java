package club.csiqu.learn.pattern.singleton.lazy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
class InterClassLazySingletonTest {

    @Test
    void testGetInstance() {
        InterClassLazySingleton instance0 = InterClassLazySingleton.getInstance();
        Assertions.assertEquals("hello", instance0.sayHello());
        InterClassLazySingleton instance1 = InterClassLazySingleton.getInstance();
        Assertions.assertEquals(instance0, instance1);
    }
}