package club.csiqu.learn.basis.jvm.loading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JVM保证 {@code <clinit>()}（编译器自动收集类中的所有的类变量初始化语句和静态语句块生成）方法线程安全，即只有一个
 * 线程会执行类初始化方法.
 *
 * @author Siqu Chen 2020/5/28
 * @since 1.0.0
 */
public class DeadLoopClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeadLoopClass.class);

    static {
        if (true) {
            LOGGER.debug("{} init DeadLoopClass", Thread.currentThread());
            while (true) {
            }
        }
    }
}
