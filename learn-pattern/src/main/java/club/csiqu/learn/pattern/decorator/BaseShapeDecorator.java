package club.csiqu.learn.pattern.decorator;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/13 17:34
 */
public abstract class BaseShapeDecorator implements Shape {

    Shape decoratedShape;

    BaseShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}