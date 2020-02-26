package club.csiqu.thread.concurrent.allocator;

/**
 * 账户操作工具类
 *
 * @author chensiqu
 * @since 2019/3/27 10:20
 */
class AccountUtils {

    /** 锁唯一实例 */
    private static SingleAllocator singleAllocator = SingleAllocator.getInstance();

    /**
     * 转账
     * <p>
     * 未加锁时多线程下出现金额不正常。
     *
     * @param src     源账户
     * @param target  目标账户
     * @param account 金额
     */
    static void transfer(Account src, Account target, int account) {
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
     * 使用 sync关键字加锁。
     *
     * @param src     源账户
     * @param target  目标账户
     * @param account 金额
     */
    synchronized static
    void syncTransfer(Account src, Account target, int account) {
        src.setBalance(src.getBalance() - account);
        target.setBalance(target.getBalance() + account);
    }
}