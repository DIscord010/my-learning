package club.csiqu.patterns.mvc;

/**
 * 作为模型：学生对象
 *
 * @author chensiqu
 * @since 2019/3/28 18:00
 */
class Student {

    private String rollNo;

    private String name;

    String getRollNo() {
        return rollNo;
    }

    void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}