package club.csiqu.framework.rpc.my.api.bean;

import java.io.Serializable;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:42
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 5401514607426423257L;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}