package club.csiqu.learn.pattern.prototype;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 14:35
 */
class Circle extends BaseShape {

    Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Circle::draw() method.");
    }
}