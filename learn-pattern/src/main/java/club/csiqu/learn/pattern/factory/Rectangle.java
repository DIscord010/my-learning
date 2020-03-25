package club.csiqu.learn.pattern.factory;

/**
 * @author chensiqu
 * @since 2019/3/13 10:34
 */
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}