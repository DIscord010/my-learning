package club.csiqu.learn.concurrent.example.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 基于 {@link AbstractQueuedSynchronizer}简单实现自定义锁。不可重入。
 *
 * @author chensiqu 2019/12/19
 * @since 1.0
 */
public class MyLock extends AbstractQueuedSynchronizer implements Lock {

    Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

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
}