package club.csiqu.learn.pattern.proxy.jdk;

/**
 * @author chensiqu
 * @since 2019/3/20 15:32
 */
public class RealSubject implements Subject{

    @Override
    public int sellBooks() {
        System.out.println("卖书");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("说话");
        return "张三";
    }
}