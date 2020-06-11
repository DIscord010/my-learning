package club.csiqu.learn.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @author Siqu Chen 2020/6/10
 * @since 1.0.0
 */
public class CallableImpl implements Callable<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallableImpl.class);

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 5; i++) {
            LOGGER.debug("{} {}", Thread.currentThread().getName(), i);
        }
        return i;
    }
}