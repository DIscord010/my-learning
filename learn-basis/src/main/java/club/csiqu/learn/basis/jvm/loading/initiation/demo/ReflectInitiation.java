package club.csiqu.learn.basis.jvm.loading.initiation.demo;

/**
 * 反射获取类对象会触发类的初始化
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/21
 */
public class ReflectInitiation {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("club.csiqu.learn.basis.jvm.loading.initiation.SuperClass");
    }
}