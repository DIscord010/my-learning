package club.csiqu.thread.concurrent.tea;


import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class MakeTeaByFutureTaskTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<String> task2 = new FutureTask<>(new MakeTeaByFutureTask.T2Task());
        FutureTask<String> task1 = new FutureTask<>(new MakeTeaByFutureTask.T1Task(task2));
        new Thread(task1).start();
        new Thread(task2).start();
        System.out.println(task1.get());
    }
}