package club.csiqu.learn.pattern.singleton;

/**
 * 懒汉式，线程不安全。
 *
 * @author chensiqu
 * @since 2019/3/13 14:00
 */
public class Singleton1 {

    private static Singleton1 instance;

    /**
     * 多线程中可能出现 new多个实例对象
     *
     * @return {@code instance}实例
     */
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    private Singleton1() {
    }
}