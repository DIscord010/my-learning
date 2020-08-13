package club.csiqu.learn.concurrent.example.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单实现不可重入锁。基于 {@code synchronized}
 * <p>
 * 当线程获得锁未释放便再申请时，会进入死锁状态。
 *
 * @author chensiqu
 * @since 2019/6/28 15:21
 */
public class NonReentrantLock implements Lock {

    private static final Logger LOGGER = LoggerFactory.getLogger(NonReentrantLock.class);

    /** 锁状态 */
    private boolean isLocked = false;

    /**
     * 加锁
     */
    @Override
    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.warn(e.getMessage());
            }
        }
        isLocked = true;
    }

    /**
     * 解锁
     */
    @Override
    public synchronized void unlock() {
        isLocked = false;
        notifyAll();
    }
}