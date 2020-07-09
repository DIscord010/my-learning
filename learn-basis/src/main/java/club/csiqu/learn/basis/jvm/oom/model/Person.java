package club.csiqu.learn.basis.jvm.oom.model;

/**
 * @author Siqu Chen 2020/5/27
 * @since 1.0.0
 */
public class Person {

    private String name;

    public Person() {
    }

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