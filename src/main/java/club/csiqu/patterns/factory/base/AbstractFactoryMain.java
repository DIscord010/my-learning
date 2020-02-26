package club.csiqu.patterns.factory.base;

/**
 * @author chensiqu
 * @since 2019/3/13 11:15
 */
public class AbstractFactoryMain {

    public static void main(String[] args) {
        // 获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        assert shapeFactory != null;
        Shape cirle = shapeFactory.getShape("circle");
        cirle.draw();
        // 获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        assert colorFactory != null;
        Color red = colorFactory.getColor("RED");
        red.fill();
    }
}