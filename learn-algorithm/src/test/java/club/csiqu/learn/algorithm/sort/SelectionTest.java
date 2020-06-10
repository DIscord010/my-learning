package club.csiqu.learn.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0.0
 */
class SelectionTest extends ArrayGenerator {

    Selection selection = new Selection();

    @Test
    void testSelection() {
        selection.select(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}