package club.csiqu.learn.pattern.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

/**
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
public class AfterReturningAdviceImpl implements AfterReturningAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(AfterReturningAdviceImpl.class);

    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Result value: {}", returnValue);
        }
    }
}