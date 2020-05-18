package club.csiqu.learn.pattern.singleton.hungry;

import club.csiqu.learn.pattern.singleton.Constants;

/**
 * 饿汉式单例。
 * 依靠类加载机制保证线程安全。
 * <p>
 * 优点：线程安全
 * 缺点：类初始化就加载
 *
 * @author Siqu Chen 2020/5/14
 * @since 1.0.0
 */
public class SimpleHungrySingleton {

    private static final SimpleHungrySingleton INSTANCE = new SimpleHungrySingleton();

    private SimpleHungrySingleton() {}

    public static SimpleHungrySingleton getInstance() {
        return INSTANCE;
    }

    public String sayHello() {
        return Constants.HELLO;
    }
}