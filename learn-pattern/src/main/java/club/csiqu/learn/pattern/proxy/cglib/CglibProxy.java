package club.csiqu.learn.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现 {@link MethodInterceptor}接口的代理类
 *
 * @author chensiqu
 * @since 2019/3/21 11:15
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    private CglibProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("###    before invocation");
        // 此处调用的是目标类原始对象，所以不会出现嵌套代理的现象
        // 如果改为 Object result = methodProxy.invokeSuper(o, objects); 则会产生嵌套代理
        Object result = methodProxy.invoke(target, objects);
        System.out.println("###    after invocation");
        return result;
    }

    @SuppressWarnings("unchecked")
    static <T> T getProxy(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibProxy(target));
        return (T) enhancer.create();
    }
}