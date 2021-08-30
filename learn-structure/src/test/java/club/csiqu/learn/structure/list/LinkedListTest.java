package club.csiqu.learn.structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2021/8/30
 * @since 1.0
 */
class LinkedListTest {

    @Test
    void testGet() {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("1");
        Assertions.assertFalse(list.contains("1"));
        Assertions.assertTrue(list.contains("2"));
    }
}