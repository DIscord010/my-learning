package club.csiqu.learn.concurrent.lock;

/**
 * 简单实现可重入锁。基于 {@code synchronized}
 *
 * @author chensiqu
 * @since 2019/6/28 16:05
 */
public class ReentrantLock {


    /** 重入次数 */
    private int lockedCount = 0;

    /** 锁标志 */
    private boolean isLocked = false;

    /** 当前获得锁的线程 */
    private Thread thread = null;

    /**
     * 加锁
     */
    private synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        // 如果锁已被获取且非当前线程获取
        while (isLocked && currentThread != thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        thread = currentThread;
        lockedCount++;
    }

    /**
     * 解锁
     */
    private synchronized void unlock() {

        Thread currentThread = Thread.currentThread();
        // 判断是否为当前线程持有锁
        if (!isLocked || currentThread != thread) {
            return;
        }
        lockedCount--;
        if (lockedCount == 0) {
            isLocked = false;
            thread = null;
            notify();
        }
    }

    static class Count {

        private final ReentrantLock lock = new ReentrantLock();

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