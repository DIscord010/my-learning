package club.csiqu.learn.basis.spi;

/**
 * @author chensiqu
 * @since 2019/6/28 13:19
 */
public class Bumblebee implements Robot{

    @Override
    public void sayHello() {
        System.out.println("Hello, I am BUmblebee.");
    }
}