package club.csiqu.learn.concurrent.mock.tea;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/8/12
 * @since 1.0
 */
class TeaMakerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeaMakerTest.class);

    private final TeaMaker serialTeaService = new SerialTeaMaker();

    private final TeaMaker futureTaskTeaService = new FutureTaskTeaMaker();

    private final TeaMaker completableFutureTeaService = new CompletableFutureTeaMaker();

    @Test
    void testMakeTea() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Assertions.assertEquals("上茶：龙井", serialTeaService.makeTea());
        stopwatch.stop();
        LOGGER.info("Make tea cost times:{}", stopwatch);
        stopwatch.reset();
        stopwatch.start();
        futureTaskTeaService.makeTea();
        stopwatch.stop();
        LOGGER.info("Make tea cost times:{}", stopwatch);
        stopwatch.reset();
        stopwatch.start();
        completableFutureTeaService.makeTea();
        stopwatch.stop();
        LOGGER.info("Make tea cost times:{}", stopwatch);
    }
}