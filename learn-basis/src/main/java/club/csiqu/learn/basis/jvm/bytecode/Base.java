package club.csiqu.learn.basis.jvm.bytecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 15:42
 */
public class Base {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base.class);

    public void process() {
        LOGGER.debug("process");
    }
}