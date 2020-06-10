package club.csiqu.learn.algorithm.sort.recursive;

import club.csiqu.learn.algorithm.sort.SortTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
public class HeapTest extends SortTest {

    Heap heap = new Heap();

    @Test
    void testHeap() {
        heap.sort(array0);
        Arrays.sort(array1);
        Assertions.assertArrayEquals(array0, array1);
    }
}