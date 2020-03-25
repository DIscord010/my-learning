package club.csiqu.learn.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chensiqu
 * @since 2019/3/20 15:33
 */
public class MyInvocationHandler implements InvocationHandler {

    private Subject realSubject;

    MyInvocationHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        if ("sellBooks".equals(method.getName())) {
            System.out.println("调用的是卖书方法");
        } else {
            System.out.println("调用的是说话方法");
        }
        return method.invoke(realSubject, args);
    }
}