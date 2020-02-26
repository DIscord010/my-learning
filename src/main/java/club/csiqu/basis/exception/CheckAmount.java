package club.csiqu.basis.exception;

class CheckAmount {

    /** 账户账号 */
    private int number;

    /** 存款金额 */
    private int balance;

    CheckAmount(int number) {
        this.number = number;
    }

    /**
     * 存钱
     *
     * @param amount 金额
     */
    void deposit(int amount) {
        this.balance += amount;
    }

    /**
     * 取钱
     *
     * @param amount 待取出金额
     * @throws InsufficientFundsException 余额不足
     */
    void withdraw(int amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            int needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    int getNumber() {
        return number;
    }

    int getBalance() {
        return balance;
    }
}