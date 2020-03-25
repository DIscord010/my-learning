package club.csiqu.learn.pattern.factory;

/**
 * @author chensiqu
 * @since 2019/3/13 10:36
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}