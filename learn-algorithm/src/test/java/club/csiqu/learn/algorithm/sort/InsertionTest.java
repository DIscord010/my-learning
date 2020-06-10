package club.csiqu.learn.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0.0
 */
class InsertionTest extends SortTest {

    Insertion insertion = new Insertion();

    @Test
    void testInsert0() {
        insertion.insert0(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }

    @Test
    void testInsert1() {
        insertion.insert1(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}