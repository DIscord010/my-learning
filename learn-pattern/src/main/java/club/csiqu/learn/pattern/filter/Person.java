package club.csiqu.learn.pattern.filter;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 15:25
 */
public class Person {

    private String name;

    private String gender;

    private String maritalStatus;

    Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    String getGender() {
        return gender;
    }

    String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public String toString() {
        return "[ Name : " + this.getName() +
                ", Gender : " + this.getGender() +
                ", Marital Status : " + this.getMaritalStatus() +
                " ]";
    }
}