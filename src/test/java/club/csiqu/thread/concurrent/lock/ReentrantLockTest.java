package club.csiqu.thread.concurrent.lock;

import club.csiqu.thread.concurrent.lock.ReentrantLock;
import org.junit.Test;

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