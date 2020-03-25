package club.csiqu.learn.concurrent.lock;

import org.junit.jupiter.api.Test;

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