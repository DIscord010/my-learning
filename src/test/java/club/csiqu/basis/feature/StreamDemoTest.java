package club.csiqu.basis.feature;

import club.csiqu.basis.MyLogger;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class StreamDemoTest {

    @Test
    public void count() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(StreamDemo.count(list), 2);
    }

    @Test
    public void list2Map() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Map<Integer, Integer> map = StreamDemo.list2Map(list);
        MyLogger.info(map);
    }

    @Test
    public void accept() {
        StringBuilder s = new StringBuilder("chen");
        StreamDemo.accept(s);
        assertEquals(s.toString(), "chenhello");
    }
}