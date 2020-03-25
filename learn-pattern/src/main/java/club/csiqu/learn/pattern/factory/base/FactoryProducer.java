package club.csiqu.learn.pattern.factory.base;

/**
 * 一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 *
 * @author chensiqu
 * @since 2019/3/13 11:13
 */
class FactoryProducer {

    static AbstractFactory getFactory(String choice) {
        if ("SHAPE".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else if ("COLOR".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}