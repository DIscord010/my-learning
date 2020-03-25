package club.csiqu.learn.framework.spring.tiny.aop;


import club.csiqu.learn.framework.spring.tiny.beans.factory.BeanFactory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 10:58
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}