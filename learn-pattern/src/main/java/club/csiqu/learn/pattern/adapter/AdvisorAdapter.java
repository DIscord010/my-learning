package club.csiqu.learn.pattern.adapter;

/**
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
public interface AdvisorAdapter {

    boolean supportsAdvice(Advice advice);

    MethodInterceptor getInterceptor(Advisor advisor);
}