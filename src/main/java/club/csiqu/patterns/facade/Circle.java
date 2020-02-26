package club.csiqu.patterns.facade;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 17:54
 */
public class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}