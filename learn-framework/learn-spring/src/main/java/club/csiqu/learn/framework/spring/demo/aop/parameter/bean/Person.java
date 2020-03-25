package club.csiqu.learn.framework.spring.demo.aop.parameter.bean;

import club.csiqu.learn.framework.spring.demo.aop.parameter.annotation.QueryParameterTransform;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/26 17:16
 */
@QueryParameterTransform
public class Person {

    @QueryParameterTransform
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