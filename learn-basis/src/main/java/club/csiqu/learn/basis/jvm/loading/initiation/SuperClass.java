package club.csiqu.learn.basis.jvm.loading.initiation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:20
 */
public class SuperClass {

    SuperClass() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperClass.class);

    static {
        LOGGER.info("superClass init!");
    }

    public static int value = 123;
}