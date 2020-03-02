package club.csiqu.basis.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class AmountTest {

    @Rule
    public ExpectedException expect = ExpectedException.none();

    @Test
    public void testAmount() throws InsufficientFundsException {
        Amount amount = new Amount(50, 10);
        amount.deposit(20);
        amount.deposit(10);
        amount.withdraw(10);
        expect.expect(InsufficientFundsException.class);
        amount.withdraw(50);
    }
}