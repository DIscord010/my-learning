package club.csiqu.learn.basis.jvm.loading.initiation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class InitiationApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitiationApplication.class);

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过子类调用父类的静态变量不会触发子类的类初始化
        LOGGER.info("Sub class value : {}", SubClass.value);
        // 被动引用：通过数组定义来引用类，不会触发类的初始化
        SuperClass[] superClasses = new SubClass[10];
        //  常量在编译期即添加进调用类的常量池中，不会触发定义常量的类的初始化。
        // 本例子中即添加进InitiationApplication的常量池中。
        LOGGER.info(Constants.HELLO_WORLD);
        // 反射获取类对象会触发类的初始化
        Class.forName("club.csiqu.learn.basis.jvm.loading.initiation.SubClass");
    }
}