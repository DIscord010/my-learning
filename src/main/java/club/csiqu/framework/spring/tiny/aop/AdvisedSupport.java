package club.csiqu.framework.spring.tiny.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 11:23
 */
class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

    TargetSource getTargetSource() {
        return targetSource;
    }

    void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}