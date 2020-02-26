package club.csiqu.basis.exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/2/26
 * @since 1.0.0
 */
public class InsufficientFundsExceptionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsufficientFundsExceptionTest.class);

    @Test
    public void testInsufficientFundsExceptionTest() {
        Amount amount = new Amount(50, 10);
        amount.deposit(20);
        amount.deposit(10);
        try {
            amount.withdraw(10);
            amount.withdraw(50);
        } catch (InsufficientFundsException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}