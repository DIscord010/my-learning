package club.csiqu.framework.spring.tiny.aop;


import org.aopalliance.aop.Advice;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 11:16
 */
public interface Advisor {

    Advice getAdvice();
}