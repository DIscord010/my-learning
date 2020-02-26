package club.csiqu.patterns.factory.base;

/**
 * @author chensiqu
 * @since 2019/3/13 11:02
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}