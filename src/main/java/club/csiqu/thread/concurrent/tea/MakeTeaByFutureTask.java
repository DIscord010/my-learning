package club.csiqu.thread.concurrent.tea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 使用 {@link FutureTask}实现最优烧水泡茶程序。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/22 9:03
 */
public class MakeTeaByFutureTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(MakeTeaByFutureTask.class);

    static class T1Task implements Callable<String> {

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

    static class T2Task implements Callable<String> {

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