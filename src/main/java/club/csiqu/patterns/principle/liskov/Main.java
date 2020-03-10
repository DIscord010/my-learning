package club.csiqu.patterns.principle.liskov;

/**
 * 里氏替换原则
 * <p>
 * 任何父类出现的地方，子类都可以出现。
 * 即子类不要覆写父类的非抽象方法，子类可以扩展父类的功能，但不能改变父类原有的功能。
 *
 * @author chensiqu
 * @since 2019/3/12 17:56
 */
public class Main {

    public static void main(String[] args) {
        Father father = new Father();
        System.out.println(father.func(100, 50));
        Son son = new Son();
        System.out.println(son.func(100, 50));
    }
}