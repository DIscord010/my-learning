package club.csiqu.learn.pattern.singleton.damage;

import java.io.Serializable;

/**
 * @author chensiqu 2019/12/5
 * @since 1.0.0
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = -2896782629930400984L;

    private static class SingletonHolder {

        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Singleton() {
    }

    private Object readResolve() {
        return getInstance();
    }
}