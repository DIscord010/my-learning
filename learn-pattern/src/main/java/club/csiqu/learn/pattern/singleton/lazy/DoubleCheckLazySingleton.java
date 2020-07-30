package club.csiqu.learn.pattern.singleton.lazy;

import club.csiqu.learn.pattern.singleton.Constants;

/**
 * 双重检查锁实现单例。
 * <p>
 * 优点：线程安全，懒加载
 * 缺点：代码不够清晰优雅
 *
 * @author Siqu Chen 2020/5/17
 * @since 1.0
 */
public class DoubleCheckLazySingleton {

    /**
     * 不加 {@code volatile}关键字经过测试也没出现空指针问题，需要再确认
     */
    private static volatile DoubleCheckLazySingleton dubboCheckLazySingleton;

    private DoubleCheckLazySingleton() {}

    public static DoubleCheckLazySingleton getInstance() {
        if (dubboCheckLazySingleton == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (dubboCheckLazySingleton == null) {
                    dubboCheckLazySingleton = new DoubleCheckLazySingleton();
                }
            }
        }
        return dubboCheckLazySingleton;
    }

    public String sayHello() {
        return Constants.HELLO;
    }
}