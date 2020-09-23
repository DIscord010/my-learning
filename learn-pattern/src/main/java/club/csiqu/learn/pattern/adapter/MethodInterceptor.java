package club.csiqu.learn.pattern.adapter;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;

/**
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
public interface MethodInterceptor {

    Object invoke(@Nonnull Method invocation, Object target, Object... args) throws Throwable;
}