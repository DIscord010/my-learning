package club.csiqu.basis.function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * java8新特性 stream()的简单使用
 *
 * @author chensiqu
 * @since 2019/3/15 11:05
 */
public class FunctionSample {

    public static void main(String[] args) {
        Integer integer = 100;
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(integer);

        List<Integer> list = Arrays.asList(1, 2, 3);

        // 使用 stream()进行过滤并统计
        long count = list.stream()
                .filter(e -> e >= 2)
                .count();
        System.out.println(count);

        // 使用 stream()将 List转 Map
        Map<Integer, Integer> map = list
                .stream()
                .map(a -> a * a)
                .collect(Collectors.toMap(a -> a, a -> a));
        System.out.println(map);
    }
}