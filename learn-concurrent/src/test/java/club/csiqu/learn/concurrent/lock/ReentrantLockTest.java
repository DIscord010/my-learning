package club.csiqu.learn.concurrent.lock;

import org.junit.jupiter.api.Test;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class ReentrantLockTest {

    @Test
    public void test() {
        ReentrantLock.Count count = new ReentrantLock.Count();
        count.print();
    }

}