package club.csiqu.patterns.prototype;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 14:34
 */
class Square extends BaseShape {

    Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Square::draw() method.");
    }
}