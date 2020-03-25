package club.csiqu.learn.basis.loading.initialtion;

/**
 * 被动引用：通过数组定义来引用类，不会出发类的初始化
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:24
 */
public class NotInitialization1Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[10];
    }
}