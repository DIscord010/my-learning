package club.csiqu.learn.basis.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static club.csiqu.learn.basis.jvm.oom.DirectMemoryOomApplication.MEMORY_SIZE_1_MB;

/**
 * VM args:-Xmx20M -XX:MaxDirectMemorySize=1M
 *
 * @author Siqu Chen 2020/11/23
 * @since 1.0.0
 */
public class UnsafeAllocateMemoryOomApplication {

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            long address = unsafe.allocateMemory(MEMORY_SIZE_1_MB);
            /// 内存初始化时才会真正使用该内存
            //unsafe.setMemory(address, MEMORY_SIZE_1_MB, (byte) 0);
        }
    }
}