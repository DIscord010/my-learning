package club.csiqu.patterns.prototype;

/**
 * 原型模式
 * <p>
 * 原型模式用于创建重复的对象，同时保证性能。
 * <p>
 * 当直接创建对象的代价比较大时，则采用这种模式。
 * 且对副本的修改 ，不会影响到原来的对象。
 * <p>
 * 例如，一个对象需要在一个高代价的数据库操作之后被创建。
 * 我们可以缓存该对象，在下一个请求时返回它的克隆；
 * 在需要的时候更新数据库，以此来减少数据库调用。
 * <p>
 * 当克隆的对象的属性都是基本类型时可以使用浅拷贝，
 * 如果克隆的对象，拥有引用属性，浅拷贝会出现线程安全问题。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 11:55
 */
public class PrototypeMain {

    public static void main(String[] args) {

        BaseShape circle = ShapeCache.getShape("1");
        circle.draw();

        BaseShape square = ShapeCache.getShape("2");
        square.draw();

        BaseShape rectangle = ShapeCache.getShape("3");
        rectangle.draw();
    }

}