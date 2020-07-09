package club.csiqu.learn.basis.jvm.oom;

import club.csiqu.learn.basis.jvm.oom.model.Person;

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
public class HeapOomApplication {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        while (true) {
            list.add(new Person("memory"));
        }
    }
}