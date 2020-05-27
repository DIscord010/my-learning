package club.csiqu.learn.basis.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出测试
 * <p>
 * VM args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * 未指定则默认与 Java堆最大值一致。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/1 8:32
 */
public class DirectMemoryOom {

    private static final int MB_1 = 1024 * 1024;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            // 打印循环次数时发现执行了 25000+次，并且调整 -XX:MaxDirectMemorySize后结果无任何区别。
            // 此处代码不一定正确，暂无结论。
            unsafe.allocateMemory(MB_1);
        }
    }
}