package club.csiqu.thread;

/**
 * 实现 Runnable接口
 */
public class RunnableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}