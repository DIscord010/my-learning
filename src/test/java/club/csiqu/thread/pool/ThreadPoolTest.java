package club.csiqu.thread.pool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class ThreadPoolTest {

    @Test
    public void test() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);
        ThreadPool pool = new ThreadPool(10, workQueue);
        pool.execute(() ->
                System.out.println("hello"));
    }
}