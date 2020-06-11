package club.csiqu.learn.concurrent.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
class RunnableImplTest {

    @Test
    void testThreadByRunnable() throws InterruptedException {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable, "通过Runnable构造的线程");
        thread.start();
        thread.join();
        Assertions.assertEquals(5, runnable.count);
    }
}