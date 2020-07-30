package club.csiqu.learn.pattern.singleton.hungry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Siqu Chen 2020/5/17
 * @since 1.0
 */
class SimpleHungrySingletonTest {

    @Test
    void testGetInstance() {
        SimpleHungrySingleton simpleHungrySingleton0 = SimpleHungrySingleton.getInstance();
        Assertions.assertEquals("hello", simpleHungrySingleton0.sayHello());
        SimpleHungrySingleton simpleHungrySingleton1 = SimpleHungrySingleton.getInstance();
        Assertions.assertEquals(simpleHungrySingleton0, simpleHungrySingleton1);
    }
}