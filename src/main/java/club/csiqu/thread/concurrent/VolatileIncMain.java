package club.csiqu.thread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程下进行 ++操作
 *
 * @author chensiqu
 * @since 2019/3/18 11:46
 */
public class VolatileIncMain {

    /** 可以保证可读性，无法保证原子性。 */
    private volatile int count = 0;

    /** 使用 java.util.concurrent.locks.Lock加锁的 count */
    private int inc = 0;

    /** jdk中的原子操作类 */
    private AtomicInteger atomicInteger = new AtomicInteger();

    private Lock lock = new ReentrantLock();

    /**
     * 通过 syncchronized加锁
     */
    private void increase() {
        synchronized (this) {
            count++;
        }
    }

    private void increaseWithAtomic() {
        atomicInteger.getAndIncrement();
    }

    /**
     * 通过 java.util.concurrent.locks.Lock加锁
     */
    private void increaseWithLock() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final VolatileIncMain test = new VolatileIncMain();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increaseWithLock();
                    test.increaseWithAtomic();
                    test.increase();
                }
            }).start();
        }
        // IDEA run默认会启动一个守护进程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        //Thread.currentThread().getThreadGroup().list();
        System.out.println(test.inc + " " + test.atomicInteger + " " + test.count);
    }
}