package club.csiqu.learn.framework.spring.tiny.aop;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 14:59
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}