package club.csiqu.learn.thread.deadlock;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
public class MathUtil {

    private MathUtil() {}

    /**
     * 这个方法会导致死锁，{@link Integer}对象默认在[-128, 127]间进行缓存。
     */
    public static int sum(int a, int b) {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                return a + b;
            }
        }
    }
}