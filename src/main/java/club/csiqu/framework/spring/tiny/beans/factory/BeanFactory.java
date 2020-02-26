package club.csiqu.framework.spring.tiny.beans.factory;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/16 16:06
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;
}