package club.csiqu.thread.concurrent.lock;

import club.csiqu.thread.concurrent.lock.NonReentrantLock;
import org.junit.Test;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class NonReentrantLockTest {

    @Test
    public void test() {
        NonReentrantLock.Count count = new NonReentrantLock.Count();
        // 阻塞，产生死锁
        count.print();
    }
}