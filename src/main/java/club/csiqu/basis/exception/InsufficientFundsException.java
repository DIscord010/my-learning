package club.csiqu.basis.exception;

/**
 * 自定义的余额异常类
 */
class InsufficientFundsException extends Exception {

    private static final long serialVersionUID = -8672262033100609324L;

    private int amount;

    InsufficientFundsException(int amount) {
        this.amount = amount;
    }

    int getAmount() {
        return amount;
    }
}