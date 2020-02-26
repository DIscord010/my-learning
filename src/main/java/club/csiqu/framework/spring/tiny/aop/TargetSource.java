package club.csiqu.framework.spring.tiny.aop;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 14:01
 */
public class TargetSource {

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    private Object target;

    TargetSource(Class<?> targetClass, Class<?>[] interfaces, Object target) {
        this.targetClass = targetClass;
        this.interfaces = interfaces;
        this.target = target;
    }

    Class<?> getTargetClass() {
        return targetClass;
    }

    Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }
}