package club.csiqu.learn.framework.spring.tiny.beans;

import club.csiqu.learn.framework.spring.tiny.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:41
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {

        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String,BeanDefinition> getRegistry() {
        return this.registry;
    }

    protected ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}