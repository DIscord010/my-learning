package club.csiqu.learn.algorithm.sort.recursive;

import club.csiqu.learn.algorithm.sort.ArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0
 */
class QuickTest extends ArrayGenerator {

    Quick quick = new Quick();

    @Test
    void testHeap() {
        quick.sort(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}