package club.csiqu.learn.pattern.singleton.damage;

import java.io.Serializable;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0
 */
public class SerializeSafeSingleton implements Serializable {

    private static final long serialVersionUID = 525515255869654308L;

    private SerializeSafeSingleton() {}

    public static SerializeSafeSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {

        private static final SerializeSafeSingleton INSTANCE = new SerializeSafeSingleton();
    }

    /**
     * 在JDK自带的反序列化中，如果序列化的类有这个方法，则会调用这个方法来获取反序列的对象实例
     *
     * @return 实例对象
     */
    public Object readResolve() {
        return getInstance();
    }
}