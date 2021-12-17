package club.csiqu.learn.basis.throwable.closeable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证 Java异常屏蔽现象
 *
 * @author Siqu Chen 2020/6/3
 * @since 1.0
 */
class AutoCloseableImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoCloseableImplTest.class);

    @Test
    void testExceptionMask() {
        // finally块抛出的异常会屏蔽 try块产生的异常
        AutoCloseableImpl autoCloseable = new AutoCloseableImpl();
        try {
            try {
                autoCloseable.sendData();
            } finally {
                autoCloseable.close();
            }
        } catch (Exception e) {
            LOGGER.debug("异常栈：", e);
            Assertions.assertEquals(0, e.getSuppressed().length);
            Assertions.assertTrue(e instanceof IllegalAccessException);
        }
    }

    @Test
    void testExceptionTryResource() {
        // finally块抛出的异常会屏蔽 try块产生的异常
        try {
            try (AutoCloseableImpl autoCloseable = new AutoCloseableImpl()) {
                autoCloseable.sendData();
            }
        } catch (Exception e) {
            LOGGER.debug("异常栈：", e);
            Assertions.assertEquals(1, e.getSuppressed().length);
        }
    }
}