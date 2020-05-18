package club.csiqu.learn.pattern.singleton.damage;

import java.io.Serializable;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0.0
 */
public class SerializableSingleton implements Serializable {

    private static final long serialVersionUID = -2896782629930400984L;

    private SerializableSingleton() {}

    public static SerializableSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {

        private static final SerializableSingleton INSTANCE = new SerializableSingleton();
    }
}