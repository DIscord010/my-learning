package club.csiqu.patterns.singleton;

/**
 * 懒汉式，线程安全。
 *
 * @author chensiqu
 * @since 2019/3/13 14:02
 */
public class Singleton2 {

    private static Singleton2 instance;

    /**
     * 加锁保证多线程单例
     * <p>
     * 多线程效率低，获取实例也加锁。
     *
     * @return {@code instance}实例
     */
    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    private Singleton2() {
    }
}