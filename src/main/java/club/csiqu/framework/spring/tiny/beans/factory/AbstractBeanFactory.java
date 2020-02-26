package club.csiqu.framework.spring.tiny.beans.factory;


import club.csiqu.framework.spring.tiny.beans.BeanDefinition;
import club.csiqu.framework.spring.tiny.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/16 16:22
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /** IoC容器 */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    /** bean处理程序，借此可以完成 AOP等功能 */
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalAccessException("no bean named " + beanName + " is defined.");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreatBean(beanDefinition);
            bean = initializeBean(bean, beanName);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    /**
     * 对 {@code bean}进行初始化操作，例如完成 AOP功能，将 {@code bean}替换成动态代理生成的代理对象。
     *
     * @param bean 对象
     * @param name {@code bean}对应的唯一 ID名称
     * @return 增强后的对象
     * @throws Exception exception
     * @see BeanPostProcessor
     */
    private Object initializeBean(Object bean, String name) throws Exception {

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for (String beanName : this.beanDefinitionNames) {
            getBean(beanName);
        }
    }

    private Object doCreatBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 通过类对象获取 {@code beanDefinitionMap}中所有该类型的 {@code bean}。
     *
     * @param type {@link Class}类对象
     * @return 所有该类型的实例对象
     * @throws Exception exception
     * @see Class#isAssignableFrom(Class)
     */
    @SuppressWarnings("unchecked")
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList();

        for (String beanDefinitionName : beanDefinitionNames) {

            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }
}