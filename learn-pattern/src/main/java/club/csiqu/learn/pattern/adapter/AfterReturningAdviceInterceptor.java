package club.csiqu.learn.pattern.adapter;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;

/**
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
public class AfterReturningAdviceInterceptor implements MethodInterceptor {

    private final AfterReturningAdvice advice;

    public AfterReturningAdviceInterceptor(AfterReturningAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(@Nonnull Method invocation, Object target, Object... args) throws Throwable {
        Object retVal = invocation.invoke(target, args);
        this.advice.afterReturning(retVal, invocation, args, target);
        return retVal;
    }
}