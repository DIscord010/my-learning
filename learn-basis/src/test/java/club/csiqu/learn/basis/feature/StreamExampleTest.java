package club.csiqu.learn.basis.feature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0
 */
class StreamExampleTest {

    @Test
    void testCount() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(2, StreamExample.count(list));
    }

    @Test
    void testListToMap() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Map<Integer, Integer> map = StreamExample.list2Map(list);
        Assertions.assertEquals(map.get(1), new Integer(1));
    }

    @Test
    void testAccept() {
        StringBuilder s = new StringBuilder("chen");
        StreamExample.accept(s);
        Assertions.assertEquals("chenhello", s.toString());
    }

    @Test
    void testNumberArray() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        Assertions.assertArrayEquals(new int[]{1, 3}, StreamExample.numberArray(numbers1, numbers2).get(0));
    }
}