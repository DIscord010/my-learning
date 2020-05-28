package club.csiqu.learn.basis.jvm.loading.initiation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:26
 */
public class Constants {

    private Constants() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);

    static {
        LOGGER.info("Constants init");
    }

    public static final String HELLO_WORLD = "hello world！";
}