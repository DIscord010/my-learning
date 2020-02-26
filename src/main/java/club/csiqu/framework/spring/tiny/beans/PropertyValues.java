package club.csiqu.framework.spring.tiny.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装一个对象所有的 {@link PropertyValue}。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:59
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    PropertyValues() {

    }

    public void addPropertyValue(PropertyValue propertyValue) {

        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }
}