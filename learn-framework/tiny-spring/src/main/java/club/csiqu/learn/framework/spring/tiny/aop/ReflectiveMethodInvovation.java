package club.csiqu.learn.framework.spring.tiny.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/21 9:48
 */
public class ReflectiveMethodInvovation implements MethodInvocation {

    protected Object target;

    protected Method method;

    Object[] arguments;

    ReflectiveMethodInvovation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}