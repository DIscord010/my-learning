package club.csiqu.learn.pattern.singleton.lazy;

import club.csiqu.learn.pattern.singleton.Constants;

/**
 * 懒汉式单例。
 * 使用Java同步机制保证线程安全。
 * <p>
 * 优点：延迟加载，现场安全
 * 缺点：获取单例的方法加锁，开销大，在并发环境下获取单例对象的效率低。
 *
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
public class SyncLazySingleton {

    private static SyncLazySingleton syncLazySingleton;

    private SyncLazySingleton() {}

    public static synchronized SyncLazySingleton getInstance() {
        if (syncLazySingleton == null) {
            syncLazySingleton = new SyncLazySingleton();
        }
        return syncLazySingleton;
    }

    public String sayHello() {
        return Constants.HELLO;
    }
}