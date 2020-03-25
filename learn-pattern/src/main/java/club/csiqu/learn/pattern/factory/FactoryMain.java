package club.csiqu.learn.pattern.factory;

/**
 * 工厂模式
 * <p>使用一个工厂对象根据名称获取类的实例对象。
 * 当增加一个产品时，需要在工厂类中对逻辑判断进行修改，不符合开闭原则。
 *
 * @author chensiqu
 * @since 2019/3/13 10:40
 */
public class FactoryMain {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape cirle = shapeFactory.getShape("circle");
        cirle.draw();
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
        Shape square = shapeFactory.getShape("square");
        square.draw();
    }
}