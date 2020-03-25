package club.csiqu.learn.concurrent.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 基于 AQS简单实现自定义锁。不可重入，且未获得锁的没有阻塞，占用资源。
 *
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class MyLock extends AbstractQueuedSynchronizer {

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

}