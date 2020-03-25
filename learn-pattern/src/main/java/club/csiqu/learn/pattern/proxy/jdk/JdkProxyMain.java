package club.csiqu.learn.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 调用处理类生成代理对象
 *
 * @author chensiqu
 * @since 2019/3/20 15:52
 */

public class JdkProxyMain {

    public static void main(String[] args) {
        MyInvocationHandler my = new MyInvocationHandler(new RealSubject());
        // newProxyInstance需要传入三个参数，第一个为指定代理类的类加载器。
        // 第二个参数为代理类需要实现的接口
        // 第三个参数为 InvocationHandler接口的实现类
        Subject proxyObject =
                (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                        new Class[]{Subject.class}, my);
        System.out.println(proxyObject.sellBooks());
        System.out.println(proxyObject.speak());
        System.out.println(proxyObject.getClass().getName());
    }
}