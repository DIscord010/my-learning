package club.csiqu.learn.pattern.singleton.lazy;

import club.csiqu.learn.pattern.singleton.Constants;

/**
 * 懒汉式单例。
 * <p>
 * 优点：使用时才初始化
 * 缺点：线程不安全
 *
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
public class SimpleLazySingleton {

    private static SimpleLazySingleton simpleLazySingleton;

    private SimpleLazySingleton() {}

    public static SimpleLazySingleton getInstance() {
        if (simpleLazySingleton == null) {
            simpleLazySingleton = new SimpleLazySingleton();
        }
        return simpleLazySingleton;
    }

    public String sayHello() {
        return Constants.HELLO;
    }
}