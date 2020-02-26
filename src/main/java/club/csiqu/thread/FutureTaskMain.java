package club.csiqu.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/21 17:47
 */
public class FutureTaskMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask =
                new FutureTask<>(new CallableThread());

        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}