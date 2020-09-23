package club.csiqu.learn.pattern.adapter;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

/**
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
public interface AfterReturningAdvice extends Advice {

    void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable;
}