package club.csiqu.framework.spring.tiny.beans;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:36
 */
public interface BeanDefinitionReader {

    /***
     * 从配置中读取 BeanDefinition
     * @param location 配置文件位置
     * @throws Exception exception
     */
    void loadBeanDefinitions(String location) throws Exception;

}