package club.csiqu.basis.exception;

/**
 * 模拟银行转账操作，验证自定义异常的抛出
 *
 * @author chensiqu
 */
public class BankMain {

    public static void main(String[] args) {
        CheckAmount c1 = new CheckAmount(101);
        System.out.println("Depositing $500...");
        c1.deposit(500);
        try {
            System.out.println("\nWithdrawing $100...");
            c1.withdraw(100);
            System.out.println("\nWithdrawing $600...");
            c1.withdraw(600);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry,but you are short $" + e.getAmount());
            e.printStackTrace();
        }
        CheckAmount c2 = new CheckAmount(102);
        // 存 100
        c2.deposit(100);
        try {
            // 取 50
            c2.withdraw(50);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
        System.out.println("账户：" + c2.getNumber() + "，剩余金额 : " + c2.getBalance());
    }
}