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
public class StreamExample {

    private StreamExample() {}

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

    /**
     * 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，
     * 应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
     */
    public static List<int[]> numberArray(List<Integer> numbers1, List<Integer> numbers2) {
        return numbers1.stream()
                .flatMap(a -> numbers2.stream().map(b -> new int[]{a, b}))
                .collect(Collectors.toList());
    }
}