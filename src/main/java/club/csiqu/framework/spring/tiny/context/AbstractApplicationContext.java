package club.csiqu.framework.spring.tiny.context;

import club.csiqu.framework.spring.tiny.beans.BeanPostProcessor;
import club.csiqu.framework.spring.tiny.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * 应用上下文
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/16 16:20
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private AbstractBeanFactory beanFactory;

    AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    void refresh() throws Exception {
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessor(beanFactory);
        onRefresh();
    }

    public abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    private void registerBeanPostProcessor(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostPorcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostPorcessor : beanPostPorcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostPorcessor);
        }
    }

    private void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }
}