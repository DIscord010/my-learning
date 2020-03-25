package club.csiqu.learn.framework.spring.tiny.beans.factory;

import club.csiqu.learn.framework.spring.tiny.BeanReference;
import club.csiqu.learn.framework.spring.tiny.aop.BeanFactoryAware;
import club.csiqu.learn.framework.spring.tiny.beans.BeanDefinition;
import club.csiqu.learn.framework.spring.tiny.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 10:54
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase() +
                                propertyValue.getName().substring(1),
                        value.getClass()
                );
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            }catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}