package club.csiqu.learn.basis.jvm.gc.demo;

/**
 * 新生代 Minor GC测试
 * <p>
 * VM args:-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * <p>
 * -Xmx20M 最大堆内存 -Xms20M 起始堆内存 -Xmn10M 年轻代内存（默认为堆的 2/3） -XX:SurvivorRatio=8 年轻代中 E区与 S区的比值
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/8 23:39
 */
public class MinorGc {

    private static final int MEMORY_SIZE_1_MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        byte[] allocation4;
        allocation1 = new byte[MEMORY_SIZE_1_MB << 1];
        allocation2 = new byte[MEMORY_SIZE_1_MB << 1];
        // 出现一次 Minor GC
        allocation3 = new byte[MEMORY_SIZE_1_MB << 1];
    }
}