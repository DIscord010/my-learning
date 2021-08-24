package club.csiqu.learn.basis.feature.stream.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Siqu Chen 2021/8/24
 * @since 1.0
 */
public class PrimeApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrimeApplication.class);

    /**
     * 返回数字n之前的全部质数与非质数集合
     *
     * @param n 数字
     * @return 数字n之前的全部质数与非质数集合
     */
    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    public static void main(String[] args) {
        LOGGER.info("{}", partitionPrimesWithCustomCollector(10));
    }
}
