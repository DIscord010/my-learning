package club.csiqu.learn.concurrent.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Java创建线程的三种方式
 *
 * @author chensiqu
 * @since 2019/3/18 14:15
 */
public class CreateThreadMain {

    public static void main(String[] args) {
        // 继承 Thread类
        new MyThread().start();
        // 继承 Runnable接口
        new Thread(new RunnableThread(), "实现Runnable的线程").start();
        FutureTask<Integer> futureTask =
                new FutureTask<>(new CallableThread());
        new Thread(futureTask, "实现Callable" +
                "接口的线程").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
        }
    }
}