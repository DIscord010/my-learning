package club.csiqu.learn.pattern.decorator;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/13 17:32
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}