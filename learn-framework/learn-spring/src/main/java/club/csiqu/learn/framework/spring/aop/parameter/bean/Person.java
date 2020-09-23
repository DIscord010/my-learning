package club.csiqu.learn.framework.spring.aop.parameter.bean;

import club.csiqu.learn.framework.spring.aop.parameter.annotation.Transform;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:16
 */
@Transform
public class Person {

    @Transform
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}