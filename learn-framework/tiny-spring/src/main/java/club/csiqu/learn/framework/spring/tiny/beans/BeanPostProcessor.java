package club.csiqu.learn.framework.spring.tiny.beans;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:33
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}