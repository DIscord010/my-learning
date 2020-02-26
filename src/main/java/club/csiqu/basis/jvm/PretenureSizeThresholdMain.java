package club.csiqu.basis.jvm;

/**
 * 大对象直接进入老年代
 * VM args:-verbose:gc -Xmx20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3000000 -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * <p>
 * -XX:PretenureSizeThreshold参数对于 Parallel Scavenge收集器不起作用。
 * 而 server模式下默认垃圾收集参数为：-XX:UseParallelGC
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/10 23:23
 */
public class PretenureSizeThresholdMain {

    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings({"unused", "UnusedAssignment"})
    public static void main(String[] args) {

        byte[] allocation;

        // 出现一次 Minor GC
        allocation = new byte[_1MB << 2];
    }
}