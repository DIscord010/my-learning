package club.csiqu.patterns.mvc;

/**
 * 模拟视图
 *
 * @author chensiqu
 * @since 2019/3/28 18:02
 */
class StudentView {

    void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student:");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}