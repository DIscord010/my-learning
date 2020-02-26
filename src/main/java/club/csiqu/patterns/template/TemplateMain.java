package club.csiqu.patterns.template;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:22
 */
public class TemplateMain {

    public static void main(String[] args) {
        BaseGame cricket = new Cricket();
        cricket.play();

        BaseGame football = new Football();
        football.play();
    }
}