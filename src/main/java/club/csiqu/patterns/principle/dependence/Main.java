package club.csiqu.patterns.principle.dependence;

/**
 * 依赖倒置原则
 * <p>
 * 高层模块不应该依赖低层模块，二者都应该依赖其抽象。
 * 抽象不应该依赖细节，细节应该依赖抽象。
 *
 * @author chensiqu
 * @since 2019/3/13 9:05
 */
public class Main {

    public static void main(String[] args) {
        Mother mother = new Mother();
        mother.narrate(new Book());
        mother.narrate(new Newspaper());
    }
}