package club.csiqu.learn.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * 实现 Callable接口
 */
public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}