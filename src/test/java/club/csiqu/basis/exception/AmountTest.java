package club.csiqu.basis.exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class AmountTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmountTest.class);

    @Test
    public void testAmount() {
        Amount amount = new Amount(50, 10);
        amount.deposit(20);
        amount.deposit(10);
        try {
            amount.withdraw(10);
            amount.withdraw(50);
        } catch (InsufficientFundsException e) {
            LOGGER.warn(e.getMessage());
            return;
        }
        throw new RuntimeException();
    }
}