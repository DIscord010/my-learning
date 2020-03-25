package club.csiqu.learn.framework.spring.tiny.beans;

/**
 * 用于 {@code bean}的属性注入。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/19 9:58
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}