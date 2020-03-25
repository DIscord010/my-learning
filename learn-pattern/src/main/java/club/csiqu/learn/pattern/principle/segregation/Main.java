package club.csiqu.learn.pattern.principle.segregation;

/**
 * 接口隔离原则
 * <p>
 * 客户端不应该依赖它不需要的接口,一个类对另一个类的依赖应该建立在最小的接口上。
 * 问题由来：类 A通过接口 I依赖类 B，类 C通过接口 I依赖类 D，
 * 如果接口 I对于类 A和类 B来说不是最小接口，则类 B和类 D必须去实现他们不需要的方法。
 * 将臃肿的接口拆分为独立的几个接口。
 *
 * @author chensiqu
 * @since 2019/3/13 9:25
 */
public class Main {

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend2(new D());
        c.depend3(new D());
    }
}