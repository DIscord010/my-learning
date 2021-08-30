package club.csiqu.learn.structure.list;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2021/8/30
 * @since 1.0
 */
class ArrayListTest {

    @Test
    void testGet() {
        ArrayList<Integer> list = new ArrayList<>(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        Assertions.assertEquals(3, list.get(1));
    }

    @Test
    void testSize() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
    }
}