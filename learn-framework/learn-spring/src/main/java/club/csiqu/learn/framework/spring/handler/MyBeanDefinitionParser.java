package club.csiqu.learn.framework.spring.handler;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.lang.Nullable;
import org.w3c.dom.Element;

/**
 * @author Siqu Chen 2020/2/19
 * @since 1.0.0
 */
public class MyBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<User> getBeanClass(@Nullable Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        bean.setLazyInit(false);
        bean.addPropertyValue("name", element.getAttribute("name"));
    }
}