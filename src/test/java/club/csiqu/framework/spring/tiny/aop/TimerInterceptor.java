package club.csiqu.framework.spring.tiny.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/21 10:35
 */
public class TimerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("Invocation of Method " + invocation.getMethod().getName() + " start!");
        Object proceed = invocation.proceed();
        System.out.println("Invocation of Method " +
                invocation.getMethod().getName() +
                " end! takes " +
                (System.nanoTime() - time) +
                " nanoseconds.");
        return proceed;
    }
}