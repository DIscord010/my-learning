package club.csiqu.learn.concurrent.mock.tea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 使用 {@link CompletableFuture}实现烧水泡茶程序。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/22 10:58
 */
public class CompletableFutureTeaMaker implements TeaMaker {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompletableFutureTeaMaker.class);

    @Override
    public String makeTea() {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(
                () -> {
                    LOGGER.info("T1：洗水壶...");
                    sleep(1);
                    LOGGER.info("T1：烧开水...");
                    sleep(15);
                }
        );
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(
                () -> {
                    LOGGER.info("T2：洗茶壶...");
                    sleep(1);
                    LOGGER.info("T2：洗茶杯...");
                    sleep(2);
                    LOGGER.info("T2：拿茶叶...");
                    sleep(1);
                    return "龙井";
                }
        );
        CompletableFuture<String> f3 = f1.thenCombine(f2, (notUse, teaLeaf) -> {
            LOGGER.info("拿到茶叶：{}", teaLeaf);
            LOGGER.info("T1：泡茶...");
            return "上茶：" + teaLeaf;
        });
        return f3.join();
    }

    private void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}