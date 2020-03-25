package club.csiqu.learn.pattern.decorator;

/**
 * 装饰器模式。
 * 向现有的对象增加功能，但是不得改变其结构。
 * 即创建一个装饰类，用来包装原有的类；在保持类方法签名完整性的前提下，提供了额外的功能。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/13 17:38
 */
public class DecoratorMain {

    public static void main(String[] args) {

        Shape circle = new Circle();
        BaseShapeDecorator redCircle = new RedBaseShapeDecorator(new Circle());
        BaseShapeDecorator redRectangle = new RedBaseShapeDecorator(new Rectangle());
        circle.draw();
        redCircle.draw();
        redRectangle.draw();
    }
}