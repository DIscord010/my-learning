package club.csiqu.learn.basis.jvm.loading.initiation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:20
 */
public class SubClass extends SuperClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubClass.class);

    private SubClass() {
        super();
    }

    static {
        LOGGER.info("SubClass init!");
    }
}