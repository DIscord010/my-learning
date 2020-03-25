package club.csiqu.learn.pattern.singleton;

/**
 * 饿汉式单例模式
 * <p>
 * 线程安全,类加载时就初始化，浪费内存。
 * 基于 classloader 机制避免了多线程的同步问题。
 *
 * @author chensiqu
 * @since 2019/3/19 9:22
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    public static Singleton3 getInstance() {
        return instance;
    }

    private Singleton3() {
    }
}