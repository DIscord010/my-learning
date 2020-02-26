package club.csiqu.basis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class MyLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyLogger.class);

    public static void info(Object arg) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("{}", arg);
        }
    }

    public static void info(String format, Object arg) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(format, arg);
        }
    }
}