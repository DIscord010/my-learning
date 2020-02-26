package club.csiqu.patterns.prototype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 14:36
 */
class ShapeCache {

    private static Map<String, BaseShape> shapeCache = new ConcurrentHashMap<>();

    static BaseShape getShape(String shapeId) {

        return (BaseShape) shapeCache.get(shapeId).clone();
    }

    static {
        Circle circle = new Circle();
        circle.setId("1");
        shapeCache.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeCache.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeCache.put(rectangle.getId(), rectangle);
    }
}