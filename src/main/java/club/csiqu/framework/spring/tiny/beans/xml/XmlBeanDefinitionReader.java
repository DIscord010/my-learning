package club.csiqu.framework.spring.tiny.beans.xml;

import club.csiqu.framework.spring.tiny.BeanReference;
import club.csiqu.framework.spring.tiny.beans.AbstractBeanDefinitionReader;
import club.csiqu.framework.spring.tiny.beans.BeanDefinition;
import club.csiqu.framework.spring.tiny.beans.PropertyValue;
import club.csiqu.framework.spring.tiny.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 解析 XML文档并初始化 {@code Map<String,BeanDefinition> registry}。
 *
 * @author chensiqu [540498860@qq.com]
 * @see AbstractBeanDefinitionReader
 * @see BeanDefinition
 * @since 2019/8/19 16:49
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputSteam();

        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            registerBeanDefinition(document);
        } finally {
            inputStream.close();
        }
    }

    private void registerBeanDefinition(Document document) {

        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {

        NodeList nodeList = root.getChildNodes();
        for (int i = 0, len = nodeList.getLength(); i < len; i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                processBeanDefinition(element);
            }

        }
    }

    private void processBeanDefinition(Element element) {
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element e, BeanDefinition beanDefinition) {
        NodeList propertyNode = e.getElementsByTagName("property");

        for (int i = 0, len = propertyNode.getLength(); i < len; i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");

                if (value != null && value.length() > 0) {

                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException(
                                "Configuration problem: <property> element for property '" + name +
                                        "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }
}