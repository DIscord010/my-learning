package club.csiqu.learn.concurrent.demo.allocator;

/**
 * 账户操作
 *
 * @author chensiqu
 * @since 2019/3/27 10:20
 */
class AccountService {

    /** 锁唯一实例 */
    private final AccountAllocator singleAllocator = AccountAllocator.getInstance();

    /**
     * 转账
     * <p>
     * 未加锁时多线程下出现金额不正常。
     *
     * @param src     源账户
     * @param target  目标账户
     * @param account 金额
     */
    void transferByAllocator(Account src, Account target, int account) throws InterruptedException {
        // 获取两个账户资源
        singleAllocator.apply(src, target);
        src.setBalance(src.getBalance() - account);
        target.setBalance(target.getBalance() + account);
        // 释放两个资源
        singleAllocator.free(src, target);
    }

    /**
     * 转账
     * <p>
     * 不加锁
     *
     * @param src     源账户
     * @param target  目标账户
     * @param account 金额
     */
    void transfer(Account src, Account target, int account) {
        src.setBalance(src.getBalance() - account);
        target.setBalance(target.getBalance() + account);
    }

    /**
     * 转账
     * <p>
     * 使用 {@code synchronized)关键字加锁，所有转账操作互斥
     *
     * @param src     源账户
     * @param target  目标账户
     * @param account 金额
     */
    synchronized void transferBySync(Account src, Account target, int account) {
        src.setBalance(src.getBalance() - account);
        target.setBalance(target.getBalance() + account);
    }
}