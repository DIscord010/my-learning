package club.csiqu.patterns.factory.base;

/**
 * @author chensiqu
 * @since 2019/3/13 11:04
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);

}