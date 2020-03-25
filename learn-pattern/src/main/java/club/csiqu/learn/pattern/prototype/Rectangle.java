package club.csiqu.learn.pattern.prototype;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 12:02
 */
class Rectangle extends BaseShape {

    Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle::draw() method.");
    }
}