package club.csiqu.framework.spring.tiny.aop;

import java.lang.reflect.Method;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 14:06
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}