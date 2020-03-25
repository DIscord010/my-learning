package club.csiqu.learn.pattern.facade;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 17:52
 */
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}