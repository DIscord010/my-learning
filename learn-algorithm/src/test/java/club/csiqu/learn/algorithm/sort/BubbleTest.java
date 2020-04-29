package club.csiqu.learn.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/4/29
 * @since 1.0.0
 */
class BubbleTest {

    Bubble bubble = new Bubble();

    int[] array0;

    int[] array1;

    @BeforeEach
    void init() {
        array0 = ArrayUtils.getRand(10, 100);
        array1 = new int[array0.length];
        System.arraycopy(array0, 0, array1, 0, array0.length);
    }

    @Test
    void bubble0() {
        bubble.bubble0(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }

    @Test
    void bubble1() {
        bubble.bubble1(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }


    @Test
    void bubble2() {
        bubble.bubble2(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}