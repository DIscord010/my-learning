package club.csiqu.framework.spring.tiny.aop;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 14:58
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}