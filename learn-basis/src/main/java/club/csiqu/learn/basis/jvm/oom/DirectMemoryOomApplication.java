package club.csiqu.learn.basis.jvm.oom;

import java.nio.ByteBuffer;

/**
 * 本机直接内存溢出测试。
 * 使用DirectByteBuffer分配内存抛出内存溢出异常时，并没有真正向操作系统申请分配内存，而是通过计算
 * 得知内存无法分配时就在代码里手动抛出异常。
 * <p>
 * VM args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * 未指定则默认与 Java堆最大值一致。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/1 8:32
 */
public class DirectMemoryOomApplication {

    static final int MEMORY_SIZE_1_MB = 1024 * 1024;

    public static void main(String[] args) {
        ByteBuffer.allocateDirect(15 * MEMORY_SIZE_1_MB);
    }
}