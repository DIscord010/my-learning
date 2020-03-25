package club.csiqu.learn.concurrent.enquiry;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 询价应用的优化。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/22 13:48
 */
public class EnquiryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnquiryService.class);

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("enquiryService-pool-%d").build();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            8,
            16,
            10L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            namedThreadFactory);

    private CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

    /**
     * 原始版本
     */
    public void enquiry0() {

        String r1 = getPriceByS1();
        save(r1);

        String r2 = getPriceByS2();
        save(r2);

        String r3 = getPriceByS3();
        save(r3);
    }

    public void enquiry1() throws ExecutionException, InterruptedException {
        Future<String> future1 = executor.submit(
                this::getPriceByS1);
        Future<String> future2 = executor.submit(
                this::getPriceByS2);
        Future<String> future3 = executor.submit(
                this::getPriceByS3);
        // 这里需要等待询价结果
        String r1 = future1.get();
        executor.submit(
                () -> save(r1)
        );
        String r2 = future2.get();
        executor.submit(
                () -> save(r2)
        );
        String r3 = future3.get();
        executor.submit(
                () -> save(r3)
        );
    }

    public void enquiry2() {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        executor.submit(
                () -> {
                    try {
                        queue.put(getPriceByS1());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        executor.submit(
                () -> {
                    try {
                        queue.put(getPriceByS2());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        executor.submit(
                () -> {
                    try {
                        queue.put(getPriceByS3());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                try {
                    save(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void enquiry3() throws InterruptedException, ExecutionException {
        completionService.submit(this::getPriceByS1);
        completionService.submit(this::getPriceByS2);
        completionService.submit(this::getPriceByS3);

        for (int i = 0; i < 3; i++) {
            String r = completionService.take().get();
            executor.execute(() -> save(r));
        }
    }

    /**
     * 模拟向电商 1询价
     *
     * @return 价格
     */
    private String getPriceByS1() {

        return "PriceByS1";
    }

    /**
     * 模拟向电商 2询价
     *
     * @return 价格
     */
    private String getPriceByS2() {

        return "PriceByS2";
    }

    /**
     * 模拟向电商 3询价
     *
     * @return 价格
     */
    private String getPriceByS3() {

        return "PriceByS3";
    }

    /**
     * 将价格保存到自己的数据库中
     *
     * @param price 价格
     */
    private void save(String price) {
        LOGGER.info(price);
    }
}