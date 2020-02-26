package club.csiqu.patterns.bridge;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/6 15:59
 */
public class RedCircle implements Drawable {

    @Override
    public void drawCicle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}