package club.csiqu.learn.concurrent.example.allocator;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户资源锁
 *
 * @author chensiqu
 * @since 2019/3/27 9:54
 */
class AccountAllocator {

    private AccountAllocator() {}

    /** 资源集合 */
    private final List<Account> accounts = new ArrayList<>(16);

    /**
     * 获取单例实例，使用静态内部类实现懒加载单例。
     *
     * @return {@code instance}单例对象
     */
    static AccountAllocator getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 申请两个资源
     *
     * @param account1 账户 1
     * @param account2 账户 2
     */
    synchronized void apply(Account account1, Account account2) throws InterruptedException {
        while (accounts.contains(account1) || accounts.contains(account2)) {
            // 释放锁
            this.wait();
        }
        accounts.add(account1);
        accounts.add(account2);
    }

    /**
     * 归还两个账户资源
     *
     * @param account1 账户 1
     * @param account2 账户 2
     */
    synchronized void free(Account account1, Account account2) {
        accounts.remove(account1);
        accounts.remove(account2);
        this.notifyAll();
    }

    private static class SingletonHolder {

        private static final AccountAllocator INSTANCE = new AccountAllocator();
    }
}