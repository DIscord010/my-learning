package club.csiqu.learn.pattern.bridge;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/6 16:02
 */
public class Circle extends BaseShape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, Drawable draw) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        draw.drawCicle(radius, x, y);
    }
}