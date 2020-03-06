package club.csiqu.basis.feature;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class StreamDemoTest {

    @Test
    public void count() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(StreamDemo.count(list), 2);
    }

    @Test
    public void list2Map() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Map<Integer, Integer> map = StreamDemo.list2Map(list);
        Assertions.assertEquals(map.get(1), new Integer(1));
    }

    @Test
    public void accept() {
        StringBuilder s = new StringBuilder("chen");
        StreamDemo.accept(s);
        Assertions.assertEquals(s.toString(), "chenhello");
    }
}