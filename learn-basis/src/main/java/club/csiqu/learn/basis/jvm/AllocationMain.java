package club.csiqu.learn.basis.jvm;

/**
 * 新生代 Minor GC测试
 * <p>
 * VM args:-verbose:gc -Xmx20M -Xxx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/8 23:39
 */
public class AllocationMain {

    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings({"unused", "UnusedAssignment"})
    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB << 1];
        allocation2 = new byte[_1MB << 1];
        allocation3 = new byte[_1MB << 1];
        // 出现一次 Minor GC
        allocation4 = new byte[_1MB << 2];
    }
}