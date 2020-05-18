package club.csiqu.learn.pattern.singleton.lazy;

import club.csiqu.learn.pattern.singleton.Constants;

/**
 * 双重检查锁实现单例。
 * <p>
 * 优点：线程安全，懒加载
 * 缺点：代码不够清晰优雅
 *
 * @author Siqu Chen 2020/5/17
 * @since 1.0.0
 */
public class DubboCheckLazySingleton {

    /**
     * 不加 {@code volatile}关键字经过测试也没出现空指针问题，需要再确认
     */
    private static volatile DubboCheckLazySingleton dubboCheckLazySingleton;

    private DubboCheckLazySingleton() {}

    public static DubboCheckLazySingleton getInstance() {
        if (dubboCheckLazySingleton == null) {
            synchronized (DubboCheckLazySingleton.class) {
                if (dubboCheckLazySingleton == null) {
                    dubboCheckLazySingleton = new DubboCheckLazySingleton();
                }

            }
        }
        return dubboCheckLazySingleton;
    }

    public String sayHello() {
        return Constants.HELLO;
    }
}