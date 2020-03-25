package club.csiqu.learn.pattern.bridge;

/**
 * 桥接模式。
 * 当一个类拥有两个变化的维度时，例如一个形状拥有形状和颜色两个维度的变化，
 * 在形状中增加颜色的引用，这样新建一个圆形形状时，只需传入对应的颜色即可。
 * 核心要点：
 * 处理多层继承结构，处理多维度变化的场景，
 * 将各个维度设计成独立的继承结构，使各个维度可以独立的扩展在抽象层建立关联。
 * 本质上即为一个变化维度持有另一个变化维度的引用，而不是采用多层继承的方式。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/6 16:03
 */
public class BridgeMain {

    public static void main(String[] args) {

        BaseShape redCircle = new Circle(100, 100, 10, new RedCircle());
        BaseShape greenCircle = new Circle(100, 100, 10, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }

}