package club.csiqu.learn.concurrent.scene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Siqu Chen 2022/10/20
 * @since 1.0
 */
public class ConcurrentHashMapPutAll {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentHashMapPutAll.class);

    /**
     * 线程总数
     */
    private static final int THREAD_COUNT = 10;

    /**
     * 元素总数
     */
    private static final int ITEM_COUNT = 1000;

    /**
     * 帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
     */
    private ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(),
                        Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public boolean wrongPutAll() throws InterruptedException {
        ConcurrentHashMap<String, Long> nowItem = getData(ITEM_COUNT - 100);
        LOGGER.info("inti size: {}", nowItem.size());
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);

        // 模拟10个任务并发
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            // 查询还需要补充多少个元素
            int gap = ITEM_COUNT - nowItem.size();
            LOGGER.info("gap size:{}", gap);
            // 补充元素
            nowItem.putAll(getData(gap));
        }));

        // 等待所有任务完成
        forkJoinPool.shutdown();
        boolean result = forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        LOGGER.info("finish size:{}", nowItem.size());
        return result;
    }

    public boolean bad() throws InterruptedException {
        ConcurrentHashMap<String, Long> stringCountMap = new ConcurrentHashMap<>(10);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10000000).parallel().forEach(i -> {
                    String key = "item" + ThreadLocalRandom.current().nextInt(10);
                    synchronized (stringCountMap) {
                        if (stringCountMap.containsKey(key)) {
                            // Key存在则+1
                            stringCountMap.put(key, stringCountMap.get(key) + 1);
                        } else {
                            // Key不存在则初始化为1
                            stringCountMap.put(key, 1L);
                        }
                    }
                }
        ));
        forkJoinPool.shutdown();
        boolean result = forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        if (!result) {
            LOGGER.error("AwaitTermination Error: {}", forkJoinPool);
        }
        return result;
    }

    public boolean good() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> stringCountMap = new ConcurrentHashMap<>(10);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10000000).parallel().forEach(i -> {
                    String key = "item" + ThreadLocalRandom.current().nextInt(10);
                    stringCountMap.computeIfAbsent(key, k -> new LongAdder()).increment();
                }
        ));
        forkJoinPool.shutdown();
        boolean result = forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        if (!result) {
            LOGGER.error("AwaitTermination Error: {}", forkJoinPool);
        }
        return result;
    }
}
