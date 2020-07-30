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
public class StreamDemoTest {

    @Test
    public void testCount() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(2, StreamDemo.count(list));
    }

    @Test
    public void testListToMap() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Map<Integer, Integer> map = StreamDemo.list2Map(list);
        Assertions.assertEquals(map.get(1), new Integer(1));
    }

    @Test
    public void testAccept() {
        StringBuilder s = new StringBuilder("chen");
        StreamDemo.accept(s);
        Assertions.assertEquals("chenhello", s.toString());
    }
}