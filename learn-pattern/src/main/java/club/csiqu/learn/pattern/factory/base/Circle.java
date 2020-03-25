package club.csiqu.learn.pattern.factory.base;

/**
 * @author chensiqu
 * @since 2019/3/13 11:00
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}