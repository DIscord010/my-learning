package club.csiqu.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 测试双重锁单例在未加 {@code volatile}时的并发问题。
 *
 * @author chensiqu
 * @since 2019/3/26 10:42
 */
public class SingletonMain {

    /** 双重锁单例 */
    private static SingletonMain instance;

    private static SingletonMain getInstance() {
        if (instance == null) {
            synchronized (SingletonMain.class) {
                if (instance == null) {
                    instance = new SingletonMain();
                }
            }
        }
        return instance;
    }

    private SingletonMain() {
    }

    public static void main(String[] args) {
        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    // 阻塞线程
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(SingletonMain.getInstance()
                        + " " + Thread.currentThread().getName());
            }).start();
        }
        // 所有线程并发执行
        System.out.println("开始并发");
        countDownLatch.countDown();
    }
}