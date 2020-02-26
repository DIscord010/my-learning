package club.csiqu.thread.concurrent;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 自定义简单限流器。
 * 同一时间内只有指定数量的线程可以获取对象池中的对象并执行操作。
 * 多余线程进行等待。
 *
 * @author chensiqu
 * @since 2019/6/21 14:22
 */
public class CurrentLimiter<T, R> {

    /** 对象池 */
    private final List<T> pool;

    /** 信号量实现实现限流器 */
    private final Semaphore semaphore;

    /**
     * 构造器
     *
     * @param size 限流大小，即最多多少线程持有 {@link T}实例对象。
     * @param t    对象实例
     */
    private CurrentLimiter(int size, T t) {

        // 此处必须使用线程安全容器
        pool = new Vector<T>() {
            private static final long serialVersionUID = -3567988713713865009L;
        };
        for (int i = 0; i < size; i++) {

            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }

    private R exec(Function<T, R> function) {
        T t = null;
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            // 如不使用线程安全容器，此处会出现 remove同一个对象，导致最终池对象数量增加
            t = pool.remove(0);
            return function.apply(t);
        } finally {
            // 如不使用线程安全容器，此处可能会进行无效 add()，导致最终池对象数量减少
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) {

        // 实例化限流器
        CurrentLimiter<Long, String> limiter = new CurrentLimiter<>(10, 2L);
        // 锁
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 50个线程并发
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    // 线程进入等待状态
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                        limiter.exec(t -> {
                                    System.out.println(t);
                                    return t.toString();
                                }
                        ));

            }).start();

        }

        System.out.println("开始并发执行");
        // 同时唤醒
        countDownLatch.countDown();
        // IDEA run默认会启动一个守护进程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(limiter.pool.size());
    }
}