package club.csiqu.learn.basis.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常验证
 * <p>
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author chensiqu
 * @since 2019/7/1 22:39
 */
public class HeapOOM {

    private static class OOMObject {

    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}