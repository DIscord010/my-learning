package club.csiqu.learn.pattern.singleton.lazy;

import club.csiqu.learn.pattern.singleton.Constants;

/**
 * 静态内部类实现单例。
 * 优点：线程安全，懒加载
 * 缺点：
 *
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
public class InterClassLazySingleton {

    private InterClassLazySingleton() {}

    public static InterClassLazySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String sayHello() {
        return Constants.HELLO;
    }

    public static class SingletonHolder {

        private SingletonHolder() {}

        private static final InterClassLazySingleton INSTANCE = new InterClassLazySingleton();
    }
}