package club.csiqu.framework.spring.tiny.aop;

import org.aopalliance.intercept.MethodInterceptor;
import club.csiqu.framework.spring.tiny.beans.BeanPostProcessor;
import club.csiqu.framework.spring.tiny.beans.factory.AbstractBeanFactory;
import club.csiqu.framework.spring.tiny.beans.factory.BeanFactory;

import java.util.List;

/**
 * AOP功能核心处理类
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 14:28
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }

    /**
     * 使用 {@link ProxyFactory}生成动态代理后的生成的实例对象。
     *
     * @param bean     实例对象
     * @param beanName 对象在 Ioc容器中的 key
     * @return 动态代理生成的代理对象
     * @throws Exception exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {

        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }
        // 获取切面增强类
        List<AspectJExpressionPointcutAdvisor> advisors = beanFactory.
                getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            // 判断传入的 bean是否需要代理
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                ProxyFactory advisedSupport = new ProxyFactory();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                TargetSource targetSource = new TargetSource(bean.getClass(), bean.getClass().getInterfaces(), bean);
                advisedSupport.setTargetSource(targetSource);
                return advisedSupport.getProxy();

            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}