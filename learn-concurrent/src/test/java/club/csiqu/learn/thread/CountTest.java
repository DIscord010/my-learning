package club.csiqu.learn.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
class CountTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountTest.class);

    /**
     * 可见性原因：线程 A和线程 B同时开始执行，那么第一次都会将 count=0读到各自的缓存，执行完 count+=1后，
     * 各自的 cpu缓存中 count都是 1，同时写入内存后内存中 count为 1，而不是我们期望的 2。
     * 原子性原因：count+=1需要三条指令，而操作系统做任务切换可能发生在任意一条指令执行完成后。
     */
    @Test
    void testThreadCount() throws InterruptedException {
        Count count = new Count();
        // 创建两个线程执行 add10()方法
        Thread thread0 = new Thread(count::add10k);
        Thread thread1 = new Thread(count::add10k);
        // 启动线程
        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();

        LOGGER.debug("count result:{}", count.getNumber());
        // 等两个线程执行完成后返回
        Assertions.assertNotEquals(200000, count.getNumber());
    }
}