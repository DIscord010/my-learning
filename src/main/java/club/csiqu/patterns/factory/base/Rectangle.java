package club.csiqu.patterns.factory.base;

/**
 * @author chensiqu
 * @since 2019/3/13 10:56
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}