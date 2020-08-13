package club.csiqu.learn.framework.spring.aop.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @author Siqu Chen
 */
public class HelloBeforeMethod implements MethodBeforeAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloBeforeMethod.class);

    @Override
    public void before(Method method, @Nullable Object[] objects, Object o) {
        LOGGER.info("Method: {} before invoke.", method.getName());
    }
}