package club.csiqu.thread.concurrent.allocator;

import org.junit.jupiter.api.Test;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class AccountTest {

    @Test
    public void test() {
        // 账户 1初始金额 10000
        Account account1 = new Account(10000);
        // 账户 2初始金额 10000
        Account account2 = new Account(20000);

        // 两组十个线程分别进行转账操作，在没加锁时误差很大。
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    AccountUtils.transfer(account1, account2, 1);
                }
            }).start();
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    AccountUtils.transfer(account2, account1, 2);
                }
            }).start();
        }
        // 等待其他进程执行完成
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("account1：" + account1.getBalance());
        System.out.println("account2：" + account2.getBalance());
    }

}