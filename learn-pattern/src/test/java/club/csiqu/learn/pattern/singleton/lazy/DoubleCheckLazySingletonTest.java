package club.csiqu.learn.pattern.singleton.lazy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
class DoubleCheckLazySingletonTest {

    @Test
    void testGetInstance() {
        DoubleCheckLazySingleton instance0 = DoubleCheckLazySingleton.getInstance();
        Assertions.assertEquals("hello", instance0.sayHello());
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        Assertions.assertEquals(instance0, instance1);
    }

}