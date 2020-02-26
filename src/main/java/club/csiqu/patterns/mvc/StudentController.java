package club.csiqu.patterns.mvc;

/**
 * 控制器
 *
 * @author chensiqu
 * @since 2019/3/28 18:05
 */
public class StudentController {

    private Student model;

    private StudentView view;

    StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    void setStudentName(String name) {
        model.setName(name);
    }

    String getStudentName() {
        return model.getName();
    }

    void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}