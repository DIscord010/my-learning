package club.csiqu.learn.concurrent.scene.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 测试死锁的产生.
 * 可以使用 VisualVM进行线程查看观察死锁。
 *
 * @author chensiqu
 * @since 2019/4/8 17:15
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    static final Executor EXECUTOR = Executors.newFixedThreadPool(20);

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            EXECUTOR.execute(() -> {
                while (true) {
                    int result = MathUtil.sum(1, 2);
                    LOGGER.debug("顺利执行:{}", result);
                }
            });
            EXECUTOR.execute(() -> {
                while (true) {
                    int result = MathUtil.sum(2, 1);
                    LOGGER.debug("顺利执行:{}", result);
                }
            });
        }
    }
}