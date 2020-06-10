package club.csiqu.learn.thread.create;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
class CallableImplTest {

    @Test
    void testThreadByCallable() throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableImpl());
        new Thread(futureTask, "通过FutureTask构造线程").start();
        Assertions.assertEquals(5, (int)futureTask.get());
    }
}