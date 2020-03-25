package club.csiqu.learn.pattern.singleton;

/**
 * 使用枚举来创建单例
 *
 * @author chensiqu
 * @since 2019/3/19 9:46
 */
public enum Singleton6 {

    /**
     * 单例
     */
    INSTANCE;

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Singleton6.INSTANCE.sayHello();
        System.out.println(Singleton6.INSTANCE);
    }
}