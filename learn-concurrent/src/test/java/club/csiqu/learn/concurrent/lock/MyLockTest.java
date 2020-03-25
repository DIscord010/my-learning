package club.csiqu.learn.concurrent.lock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class MyLockTest {

    private static int count1;

    private void addCount1() {
        int index = 0;
        while (index++ < 100000) {
            count1 += 1;
        }
    }

    @Test
    public void testConcurrentAdd() throws InterruptedException {
        // 创建两个线程执行 add10()方法
        Thread th1 = new Thread(this::addCount1);
        Thread th2 = new Thread(this::addCount1);
        // 启动线程
        th1.start();
        th2.start();

        th1.join();
        th2.join();
        // 等两个线程执行完成后返回
        Assertions.assertNotEquals(200000, count1);
    }

    private static int count2;

    private void addCount2() {
        int index = 0;
        while (index++ < 10000) {
            count2 += 1;
        }
    }

    /**
     * 使用自定义锁来保证并发安全
     *
     * @throws InterruptedException 中断异常
     */
    @Test
    public void testLockAdd() throws InterruptedException {

        MyLock lock = new MyLock();
        // 创建两个线程执行 add10()方法
        Thread th1 = new Thread(() -> {
            try {
                lock.lock();
                addCount2();
            } finally {
                lock.unlock();
            }
        });
        Thread th2 = new Thread(() -> {
            try {
                lock.lock();
                addCount2();
            } finally {
                lock.unlock();
            }
        });
        // 启动线程
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        // 等两个线程执行完成后返回
        Assertions.assertEquals(20000, count2);
    }
}