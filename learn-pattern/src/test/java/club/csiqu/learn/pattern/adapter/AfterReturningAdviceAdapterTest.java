package club.csiqu.learn.pattern.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * 将{@link AfterReturningAdvice}接口适配为{@link MethodInterceptor}接口
 *
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
class AfterReturningAdviceAdapterTest {

    @Test
    void testAdapter() throws Throwable {
        String test = "test";
        Method method = String.class.getMethod("charAt", int.class);
        Advisor advisor = new AdvisorImpl(new AfterReturningAdviceImpl());
        AdvisorAdapter adapter = new AfterReturningAdviceAdapter();
        if (adapter.supportsAdvice(advisor.getAdvice())) {
            MethodInterceptor methodInterceptor = adapter.getInterceptor(advisor);
            Object retVal = methodInterceptor.invoke(method, test, 1);
            Assertions.assertEquals('e', retVal);
        }
    }
}