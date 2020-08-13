package club.csiqu.learn.concurrent.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Siqu Chen 2020/7/30
 * @since 1.0
 */
class FibonacciTest {

    @Test
    void testFibonacci() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(new Fibonacci(5));
        Assertions.assertEquals(5, result);
    }
}