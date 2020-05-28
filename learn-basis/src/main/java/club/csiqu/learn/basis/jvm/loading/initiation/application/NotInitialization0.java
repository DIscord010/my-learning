package club.csiqu.learn.basis.jvm.loading.initiation.application;

import club.csiqu.learn.basis.jvm.loading.initiation.SubClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过子类调用父类的静态变量不会触发子类的类初始化
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:19
 */
public class NotInitialization0 {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotInitialization0.class);

    public static void main(String[] args) {
        LOGGER.info("Sub class value : {}", SubClass.value);
    }
}