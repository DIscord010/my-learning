package club.csiqu.learn.algorithm.sort;

import org.junit.jupiter.api.BeforeEach;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0
 */
public class ArrayGenerator {

    protected int[] array0;

    protected int[] array1;

    @BeforeEach
    void init() {
        array0 = ArrayUtils.getRand(10, 100);
        array1 = new int[array0.length];
        System.arraycopy(array0, 0, array1, 0, array0.length);
    }
}