package club.csiqu.learn.basis.exception;

/**
 * 自定义的余额异常类
 */
class InsufficientFundsException extends Exception {

    private static final long serialVersionUID = -8672262033100609324L;

    private int amount;

    InsufficientFundsException(int amount) {
        super("金额不足，差值为 " + amount);
        this.amount = amount;
    }

    int getAmount() {
        return amount;
    }
}