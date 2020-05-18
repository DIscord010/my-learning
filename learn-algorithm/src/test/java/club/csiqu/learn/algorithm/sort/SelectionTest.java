package club.csiqu.learn.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0.0
 */
class SelectionTest {

    Selection selection = new Selection();

    int[] array0;

    int[] array1;

    @BeforeEach
    void init() {
        array0 = ArrayUtils.getRand(10, 100);
        array1 = new int[array0.length];
        System.arraycopy(array0, 0, array1, 0, array0.length);
    }

    @Test
    void testSelect() {
        selection.select(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}