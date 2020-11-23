package club.csiqu.learn.basis;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cacheLine通常为64字节，而Java中long类型变量为8字节，即一个缓存行可以存放8个long类型变量。
 *
 * @author Siqu Chen 2020/11/23
 * @since 1.0.0
 */
public class CacheLineEffectApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheLineEffectApplication.class);

    private static final int MILLION = 1000000;

    public static void main(String[] args) {
        long[][] array = new long[MILLION][8];
        for (int i = 0; i < MILLION; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = 1L;
            }
        }
        long temp = 0L;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < MILLION; i++) {
            for (int j = 0; j < 8; j++) {
                temp = array[i][j];
            }
        }
        LOGGER.info("Loop times: {}", stopwatch.stop());

        stopwatch.reset();
        stopwatch.start();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < MILLION; j++) {
                temp = array[j][i];
            }
        }
        LOGGER.info("Loop times: {}", stopwatch.stop());
        LOGGER.info("Temp: {}", temp);
    }
}