package club.csiqu.learn.pattern.bridge;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/6 16:01
 */
public abstract class BaseShape {

    Drawable draw;

    BaseShape(Drawable draw) {

        super();
        this.draw = draw;
    }

    public abstract void draw();
}