package club.csiqu.learn.basis.jvm.oom.application;

import club.csiqu.learn.basis.jvm.oom.OomObject;

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
public class HeapOom {

    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();
        while (true) {
            list.add(new OomObject("Out of memory"));
        }
    }
}