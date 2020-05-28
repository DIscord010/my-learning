package club.csiqu.learn.basis.jvm.loading.initiation.application;

import club.csiqu.learn.basis.jvm.loading.initiation.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 常量在编译期即添加进调用类的常量池中，不会触发定义常量的类的初始化。
 * 本例子中即添加进 {@link NotInitialization2}的常量池中。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:25
 */
public class NotInitialization2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotInitialization2.class);

    public static void main(String[] args) {
        LOGGER.info(Constants.HELLO_WORLD);
    }
}