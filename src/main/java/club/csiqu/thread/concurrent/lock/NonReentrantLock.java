package club.csiqu.thread.concurrent.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单实现不可重入锁。基于 {@code synchronized}
 * <p>
 * <p>
 * 当线程获得锁未释放便再申请时，会进入死锁状态。
 *
 * @author chensiqu
 * @since 2019/6/28 15:21
 */
public class NonReentrantLock {

    /** 日志 */
    private final Logger logger = LoggerFactory.getLogger(NonReentrantLock.class);

    /** 锁状态 */
    private boolean isLocked = false;

    /**
     * 加锁
     */
    private synchronized void lock() {

        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
        isLocked = true;
    }

    /**
     * 解锁
     */
    private synchronized void unlock() {
        isLocked = false;
        notify();
    }

    /**
     * 使用 {@link NonReentrantLock}实现线程安全
     */
    static class Count {

        private final NonReentrantLock lock = new NonReentrantLock();

        void print() {
            lock.lock();

            try {
                System.out.println("do print");
                doAdd();
            } finally {
                lock.unlock();
            }
        }

        void doAdd() {
            lock.lock();
            try {
                // do something
                System.out.println("do doAdd");
            } finally {
                lock.unlock();
            }
        }
    }
}