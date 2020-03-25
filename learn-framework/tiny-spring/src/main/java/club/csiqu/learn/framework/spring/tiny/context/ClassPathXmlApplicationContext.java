package club.csiqu.learn.framework.spring.tiny.context;


import club.csiqu.learn.framework.spring.tiny.beans.BeanDefinition;
import club.csiqu.learn.framework.spring.tiny.beans.factory.AbstractBeanFactory;
import club.csiqu.learn.framework.spring.tiny.beans.factory.AutowireCapableBeanFactory;
import club.csiqu.learn.framework.spring.tiny.beans.io.ResourceLoader;
import club.csiqu.learn.framework.spring.tiny.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 10:51
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    private ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }


    @Override
    public void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}