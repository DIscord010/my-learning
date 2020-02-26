package club.csiqu.thread.concurrent.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 使用 {@link ForkJoinPool}计算斐波切那数列。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/23 16:58
 */
public class FibonacciSequenceByForkJoin {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        Fibonacci fibonacci = new Fibonacci(50L);
        long result = forkJoinPool.invoke(fibonacci);
        System.out.println(result);
    }

    static class Fibonacci extends RecursiveTask<Long> {

        private static final long serialVersionUID = 5430812783843847303L;

        final long n;

        Fibonacci(long n) {
            this.n = n;
        }

        @Override
        protected Long compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }
    }
}