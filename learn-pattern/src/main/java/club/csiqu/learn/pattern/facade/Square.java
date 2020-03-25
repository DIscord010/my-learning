package club.csiqu.learn.pattern.facade;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 17:53
 */
public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}