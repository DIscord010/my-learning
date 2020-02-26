package club.csiqu.thread.concurrent.lock;

import club.csiqu.thread.concurrent.lock.MyLock;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class MyLockTest {

    private static int count;

    private void add10k() {
        int index = 0;
        while (index++ < 10000) {
            count += 1;
        }
    }

    @Test
    public void testConcurrentAdd() throws InterruptedException {
        // 创建两个线程执行 add10()方法
        Thread th1 = new Thread(this::add10k);
        Thread th2 = new Thread(this::add10k);
        // 启动线程
        th1.start();
        th2.start();

        th1.join();
        th2.join();
        // 等两个线程执行完成后返回
        Assert.assertNotEquals(20000, count);
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
                add10k();
            } finally {
                lock.unlock();
            }
        });
        Thread th2 = new Thread(() -> {
            try {
                lock.lock();
                add10k();
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
        Assert.assertEquals(20000, count);
    }
}