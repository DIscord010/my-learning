package club.csiqu.learn.concurrent.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0
 */
class DemoThreadTest {

    @Test
    void testDemoThread() throws InterruptedException {
        DemoThread demoThread = new DemoThread();
        demoThread.start();
        demoThread.join();
        Assertions.assertEquals(5, demoThread.count);
    }
}