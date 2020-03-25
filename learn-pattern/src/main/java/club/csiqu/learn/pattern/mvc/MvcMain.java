package club.csiqu.learn.pattern.mvc;

/**
 * MVC模式
 * <p>
 * 视图不直接把模型传入，而是依靠一个控制器传入所需参数。
 * 达到视图和模型分离。
 *
 * @author chensiqu
 * @since 2019/3/29 9:37
 */
public class MvcMain {

    public static void main(String[] args) {
        Student model = new Student();
        model.setName("test");
        model.setRollNo("10");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();

        controller.setStudentName("John");
        controller.updateView();
    }
}