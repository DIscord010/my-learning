package club.csiqu.patterns.decorator;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/13 17:35
 */
public class RedBaseShapeDecorator extends BaseShapeDecorator {

    RedBaseShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Border Color： Red");
    }
}