package club.csiqu.learn.concurrent.demo.lock;

/**
 * @author Siqu Chen 2020/8/3
 * @since 1.0
 */
public interface Lock {

    /**
     * 加锁
     */
    void lock();

    /**
     * 解锁
     */
    void unlock();
}