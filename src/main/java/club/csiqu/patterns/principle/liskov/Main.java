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
        A a = new A();
        System.out.println(a.funcA(100, 50));
        B b = new B();
        System.out.println(b.funcA(100, 50));
        System.out.println(b.funcB(100, 50));
    }
}