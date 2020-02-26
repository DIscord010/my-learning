package club.csiqu.patterns.factory;

/**
 * @author chensiqu
 * @since 2019/3/13 10:35
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}