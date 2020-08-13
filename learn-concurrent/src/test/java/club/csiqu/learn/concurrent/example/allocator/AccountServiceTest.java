package club.csiqu.learn.concurrent.example.allocator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Siqu Chen 2020/6/11
 * @since 1.0
 */
class AccountServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceTest.class);

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    private final AccountService accountService = new AccountService();

    private Account account1;

    private Account account2;

    @BeforeEach
    void initAccount() {
        account1 = new Account(100000);
        account2 = new Account(200000);
    }

    @Test
    void testTransferByAllocator() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        executor.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    accountService.transferByAllocator(account1, account2, 1);
                } catch (InterruptedException e) {
                    LOGGER.warn("中断异常：{}", e.getMessage());
                }
            }
            countDownLatch.countDown();
        });
        executor.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    accountService.transferByAllocator(account2, account1, 2);
                } catch (InterruptedException e) {
                    LOGGER.warn("中断异常：{}", e.getMessage());
                }
            }
            countDownLatch.countDown();
        });
        countDownLatch.await();
        Assertions.assertEquals(200000, account1.getBalance());
        Assertions.assertEquals(100000, account2.getBalance());
    }

    @Test
    void testTransfer() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        executor.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                accountService.transfer(account1, account2, 1);
            }
            countDownLatch.countDown();
        });
        executor.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                accountService.transfer(account2, account1, 2);
            }
            countDownLatch.countDown();
        });
        countDownLatch.await();
        Assertions.assertNotEquals(200000, account1.getBalance());
        Assertions.assertNotEquals(100000, account2.getBalance());
    }

    @Test
    void testTransferBySync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        executor.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                accountService.transferBySync(account1, account2, 1);
            }
            countDownLatch.countDown();
        });
        executor.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                accountService.transferBySync(account2, account1, 2);
            }
            countDownLatch.countDown();
        });
        countDownLatch.await();
        Assertions.assertEquals(200000, account1.getBalance());
        Assertions.assertEquals(100000, account2.getBalance());
    }
}