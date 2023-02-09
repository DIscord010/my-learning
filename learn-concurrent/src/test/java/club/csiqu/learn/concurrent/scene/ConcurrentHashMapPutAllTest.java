package club.csiqu.learn.concurrent.scene;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2022/10/20
 * @since 1.0
 */
class ConcurrentHashMapPutAllTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentHashMapPutAllTest.class);

    ConcurrentHashMapPutAll concurrentHashMapPutAll = new ConcurrentHashMapPutAll();

    @Test
    void wrongPutAll() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Assertions.assertTrue(concurrentHashMapPutAll.wrongPutAll());
        }
    }

    @Test
    void good() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Assertions.assertTrue(concurrentHashMapPutAll.good());
        LOGGER.info("Good count time: {}", stopwatch.stop());
        stopwatch.start();
        Assertions.assertTrue(concurrentHashMapPutAll.bad());
        LOGGER.info("Bad count time: {}", stopwatch.stop());
    }
}