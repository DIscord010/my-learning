package club.csiqu.learn.concurrent.scene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/6/11
 * @since 1.0.0
 */
class CurrentCountTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentCountTest.class);

    /**
     * 可见性原因：线程 A和线程 B同时开始执行，那么第一次都会将 count=0读到各自的缓存，执行完 count+=1后，
     * 各自的 cpu缓存中 count都是 1，同时写入内存后内存中 count为 1，而不是我们期望的 2。
     * 原子性原因：count+=1需要三条指令，而操作系统做任务切换可能发生在任意一条指令执行完成后。
     */
    @Test
    void testCurrentCount() throws InterruptedException {
        CurrentCount currentCount = new CurrentCount();
        currentCount.currentAdd();
        LOGGER.debug("result:{}", currentCount.getNumber());
        Assertions.assertNotEquals(20000000, currentCount.getNumber());
    }
}