package club.csiqu.learn.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
public class RunnableImpl implements Runnable {

    int count = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(RunnableImpl.class);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count++;
            LOGGER.debug("{} {}", Thread.currentThread().getName(), i);
        }
    }
}