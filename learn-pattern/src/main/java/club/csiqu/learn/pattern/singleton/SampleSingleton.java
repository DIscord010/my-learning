package club.csiqu.learn.pattern.singleton;

/**
 * @author chensiqu
 * @since 2019/3/13 11:27
 */
public class SampleSingleton {

    /** 唯一实例对象 */
    private static SampleSingleton instance = new SampleSingleton();

    /**
     * 构造函数私有，该类则不会被实例化
     */
    private SampleSingleton() {

    }

    public static SampleSingleton getInstance() {
        return instance;
    }

    void showMessage() {
        System.out.println("hello world!");
    }
}