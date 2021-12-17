package club.csiqu.learn.basis.throwable;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0
 */
public class AmountTest {

    @Test
    public void testAmount() throws InsufficientFundsException {
        Amount amount = new Amount(50, 10);
        amount.deposit(20);
        amount.deposit(10);
        amount.withdraw(10);
        Assertions.assertThrows(InsufficientFundsException.class,
                () -> amount.withdraw(50));
    }
}