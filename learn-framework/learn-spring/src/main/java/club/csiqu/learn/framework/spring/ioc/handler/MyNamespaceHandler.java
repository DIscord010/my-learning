package club.csiqu.learn.framework.spring.ioc.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author Siqu Chen 2020/2/19
 * @since 1.0
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new MyBeanDefinitionParser());
    }
}