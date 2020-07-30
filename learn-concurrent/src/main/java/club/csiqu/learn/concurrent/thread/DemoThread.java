package club.csiqu.learn.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 继承 Thread类
 * <p>
 * 线程生命周期可以用五个状态表示：初始状态、可运行状态、运行状态、休眠状态和终止状态。
 *
 * @author Siqu Chen 2020/6/10
 * @since 1.0
 */
public class DemoThread extends Thread {

    int count = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoThread.class);

    /**
     * 重写run方法，run方法的方法体就是现场执行体。
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count++;
            LOGGER.debug("{} {}", getName(), i);
        }
    }
}