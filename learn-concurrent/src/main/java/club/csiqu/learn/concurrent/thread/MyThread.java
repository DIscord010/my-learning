package club.csiqu.learn.concurrent.thread;

/**
 * 继承 Thread类
 *
 * 线程生命周期可以用五个状态表示：初始状态、可运行状态、运行状态、休眠状态和终止状态。
 */
public class MyThread extends Thread {

    /**
     * 重写run方法，run方法的方法体就是现场执行体。
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}