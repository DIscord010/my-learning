package club.csiqu.thread.concurrent.allocator;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author Siqu Chen 2020/3/13
 * @since 1.0.0
 */
class AccountServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceTest.class);

    AccountService accountService = new AccountService();

    private ExecutorService executor0 = new ThreadPoolExecutor(
            10,
            10,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("account1-server-pool-%d").build());

    private ExecutorService executor1 = new ThreadPoolExecutor(
            10,
            10,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("account2-server-pool-%d").build());

    @Test
    void transferByAllocator() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        CountDownLatch countDownLatch = new CountDownLatch(200);
        // 账户 1初始金额 10000
        Account account1 = new Account(100000);
        // 账户 2初始金额 10000
        Account account2 = new Account(200000);
        // 十个线程分别进行转账操作，在没加锁时误差很大
        for (int i = 0; i < 100; i++) {
            executor0.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountService.transferByAllocator(account1, account2, 1);
                }
                countDownLatch.countDown();
            });
            executor1.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountService.transferByAllocator(account2, account1, 2);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        stopwatch.stop();
        LOGGER.info("cost time: {}", stopwatch);
        Assertions.assertEquals(account1.getBalance(), 200000);
    }

    @Test
    void transferSync() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        CountDownLatch countDownLatch = new CountDownLatch(200);
        // 账户 1初始金额 10000
        Account account1 = new Account(100000);
        // 账户 2初始金额 10000
        Account account2 = new Account(200000);
        // 十个线程分别进行转账操作，在没加锁时误差很大。
        for (int i = 0; i < 100; i++) {
            executor0.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountService.transferBySync(account1, account2, 1);
                }
                countDownLatch.countDown();
            });
            executor1.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountService.transferBySync(account2, account1, 2);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        stopwatch.stop();
        LOGGER.info("cost time: {}", stopwatch);
        Assertions.assertEquals(account1.getBalance(), 200000);
    }

    @Test
    void transfer() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(200);
        // 账户 1初始金额 10000
        Account account1 = new Account(100000);
        // 账户 2初始金额 10000
        Account account2 = new Account(200000);
        // 十个线程分别进行转账操作，在没加锁时误差很大。
        for (int i = 0; i < 100; i++) {
            executor0.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountService.transfer(account1, account2, 1);
                }
                countDownLatch.countDown();
            });
            executor1.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountService.transfer(account2, account1, 2);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        Assertions.assertNotEquals(account1.getBalance(), 200000);
    }
}