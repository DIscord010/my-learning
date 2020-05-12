package club.csiqu.learn.basis.io.net;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Siqu Chen 2020/5/12
 * @since 1.0.0
 */
public class ExecutorFactory {

    private ExecutorFactory() {}

    /**
     * 获取单一线程线程池
     *
     * @param threadNameFormat 命名格式
     * @return {@link ThreadPoolExecutor}
     */
    public static Executor newSingleThreadExecutor(String threadNameFormat) {
        return new ThreadPoolExecutor(
                1,
                1,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                new ThreadFactoryBuilder().setNameFormat(threadNameFormat).build());
    }
}