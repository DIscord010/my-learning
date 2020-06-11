package club.csiqu.learn.basis.feature;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Java8新特性 stream()的简单使用
 *
 * @author chensiqu
 * @since 2019/3/15 11:05
 */
public class StreamDemo {

    private StreamDemo() {}

    public static long count(List<Integer> list) {
        // 使用 stream()进行统计大于 2的数量
        return list.stream()
                .filter(e -> e >= 2)
                .count();
    }

    public static Map<Integer, Integer> list2Map(List<Integer> list) {
        // 使用 stream()将 List转 Map
        return list.stream()
                .map(a -> a * a)
                .collect(Collectors.toMap(a -> a, a -> a));
    }

    public static void accept(StringBuilder stringBuilder) {
        Consumer<StringBuilder> consumer = s -> s.append("hello");
        consumer.accept(stringBuilder);
    }
}