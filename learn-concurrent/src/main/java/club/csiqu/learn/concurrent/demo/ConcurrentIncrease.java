package club.csiqu.learn.concurrent.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程下进行 ++操作
 *
 * @author chensiqu
 * @since 2019/3/18 11:46
 */
public class ConcurrentIncrease {

    /** 可以保证可读性，无法保证原子性。 */
    private volatile int count = 0;

    /** 使用 java.util.concurrent.locks.Lock加锁的 count */
    private int increase = 0;

    /** JDK */
    private final AtomicInteger atomicInteger = new AtomicInteger();

    private final Lock lock = new ReentrantLock();

    /**
     * 通过 synchronized加锁
     */
    protected void increase() {
        synchronized (this) {
            count++;
        }
    }

    protected void increaseWithAtomic() {
        atomicInteger.getAndIncrement();
    }

    /**
     * 通过 java.util.concurrent.locks.Lock加锁
     */
    protected void increaseWithLock() {
        lock.lock();
        try {
            increase++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}