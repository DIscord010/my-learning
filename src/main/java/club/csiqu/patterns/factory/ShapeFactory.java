package club.csiqu.patterns.factory;

/**
 * @author chensiqu
 * @since 2019/3/13 10:37
 */
class ShapeFactory {

    /**
     * 获取形状类型的对象
     *
     * @param shapeType 类型
     * @return 对象实例
     */
    Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }
}