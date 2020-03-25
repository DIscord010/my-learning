package club.csiqu.learn.pattern.factory.base;

/**
 * @author chensiqu
 * @since 2019/3/13 10:59
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}