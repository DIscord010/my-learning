package club.csiqu.learn.concurrent.mock.tea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 使用 {@link FutureTask}实现最优烧水泡茶程序。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/22 9:03
 */
public class FutureTaskTeaMaker implements TeaMaker {

    Executor executor = Executors.newFixedThreadPool(10);

    private static final Logger LOGGER = LoggerFactory.getLogger(FutureTaskTeaMaker.class);

    @Override
    public String makeTea() throws InterruptedException {
        FutureTask<String> task2 = new FutureTask<>(new T2Task());
        FutureTask<String> task1 = new FutureTask<>(new T1Task(task2));
        executor.execute(task1);
        executor.execute(task2);
        try {
            return task1.get();
        } catch (ExecutionException e) {
            LOGGER.warn("线程执行异常：", e);
            return "泡茶失败";
        }
    }

    private static class T1Task implements Callable<String> {

        FutureTask<String> t2FutureTask;

        T1Task(FutureTask<String> t2FutureTask) {
            this.t2FutureTask = t2FutureTask;
        }

        @Override
        public String call() throws InterruptedException, ExecutionException {
            LOGGER.info("T1：洗水壶...");
            TimeUnit.SECONDS.sleep(1);
            LOGGER.info("T1：烧开水...");
            TimeUnit.SECONDS.sleep(15);
            String teaLeaf = t2FutureTask.get();
            LOGGER.info("T1：拿到茶叶：{}", teaLeaf);
            LOGGER.info("T1：泡茶...");
            return "上茶：" + teaLeaf;
        }
    }

    private static class T2Task implements Callable<String> {

        @Override
        public String call() throws InterruptedException {
            LOGGER.info("T2：洗茶壶...");
            TimeUnit.SECONDS.sleep(1);
            LOGGER.info("T2：洗茶杯...");
            TimeUnit.SECONDS.sleep(2);
            LOGGER.info("T2：拿茶叶");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }
}