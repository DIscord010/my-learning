package club.csiqu.practice.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/3/13
 * @since 1.0.0
 */
class ArraySummaryTest {

    ArraySummary arraySummary = new ArraySummary();

    @Test
    void minMoves2() {
        int[] array = new int[]{203125577, -349566234, 230332704,
                48321315, 66379082, 386516853,
                50986744, -250908656, -425653504, -212123143};
        int r = arraySummary.minMoves2(array);
        Assertions.assertEquals(r, 2127271182);
        Assertions.assertEquals(arraySummary.minMoves2Median(array), r);
    }
}