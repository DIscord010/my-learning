package club.csiqu.learn.basis.throwable.exception;

/**
 * 账户
 */
class Amount {

    /** 账户账号 */
    private Integer number;

    /** 存款金额 */
    private Integer balance;

    public Amount(Integer number, Integer balance) {
        this.number = number;
        this.balance = balance;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * 存钱
     *
     * @param amount 金额
     */
    void deposit(Integer amount) {
        this.balance += amount;
    }

    /**
     * 取钱
     *
     * @param amount 待取出金额
     * @throws InsufficientFundsException 余额不足
     */
    void withdraw(Integer amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance = balance - amount;
    }

    Integer getNumber() {
        return number;
    }

    Integer getBalance() {
        return balance;
    }
}