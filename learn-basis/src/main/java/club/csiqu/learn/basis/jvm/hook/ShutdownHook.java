package club.csiqu.learn.basis.jvm.hook;

/**
 * 可以通过 {@code addShutdownHook()}方法为虚拟机添加优雅退出时的钩子.
 *
 * @author Siqu Chen 2020/5/28
 * @since 1.0
 */
public class ShutdownHook {

    public void addShutdownHook(Thread hook) {
        Runtime.getRuntime().addShutdownHook(hook);
    }
}