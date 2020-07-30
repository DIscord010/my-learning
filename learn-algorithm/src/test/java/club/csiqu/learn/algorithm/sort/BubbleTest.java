package club.csiqu.learn.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/4/29
 * @since 1.0
 */
class BubbleTest extends ArrayGenerator {

    Bubble bubble = new Bubble();

    @Test
    void testBubble0() {
        bubble.bubble0(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }

    @Test
    void testBubble1() {
        bubble.bubble1(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }

    @Test
    void testBubble2() {
        bubble.bubble2(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}