package club.csiqu.learn.pattern.bridge;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/6 16:00
 */
public class GreenCircle implements Drawable {

    @Override
    public void drawCicle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}