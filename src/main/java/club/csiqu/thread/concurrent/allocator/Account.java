package club.csiqu.thread.concurrent.allocator;

/**
 * 模拟账户
 *
 * @author chensiqu
 * @since 2019/3/27 9:56
 */
class Account {

    /** 账户金额 */
    private int balance;

    /**
     * 构造函数
     * @param balance 初始开户金额
     */
    Account(int balance) {
        this.balance = balance;
    }

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }
}