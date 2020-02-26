package club.csiqu.patterns.singleton.damage;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chensiqu 2019/12/6
 * @since 1.0.0
 */
public class ReflectionMain {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton singleton = Singleton.getInstance();
        Class<Singleton> clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        Singleton reflectionSingleton = constructor.newInstance();
        System.out.println(singleton);
        System.out.println(reflectionSingleton);
    }
}