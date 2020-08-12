package club.csiqu.learn.concurrent.mock.tea;

/**
 * @author Siqu Chen 2020/8/11
 * @since 1.0
 */
public interface TeaMaker {

    String makeTea() throws InterruptedException;
}