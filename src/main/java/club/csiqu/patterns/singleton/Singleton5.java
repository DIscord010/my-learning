package club.csiqu.patterns.singleton;

/**
 * 登记式/静态内部类
 *
 * @author chensiqu
 * @since 2019/3/19 9:42
 */
public class Singleton5 {

    private static class SingletonHolder {
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }

    private Singleton5() {
    }
}