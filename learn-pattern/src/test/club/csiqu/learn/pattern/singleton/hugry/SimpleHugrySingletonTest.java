package club.csiqu.learn.pattern.singleton.hugry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
class SimpleHugrySingletonTest {

    @Test
    void testGetInstance() {
        SimpleHugrySingleton simpleHugrySingleton0 = SimpleHugrySingleton.getInstance();
        Assertions.assertEquals("hello", simpleHugrySingleton0.sayHello());
        SimpleHugrySingleton simpleHugrySingleton1 = SimpleHugrySingleton.getInstance();
        Assertions.assertEquals(simpleHugrySingleton0, simpleHugrySingleton1);
    }
}