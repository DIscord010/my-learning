package club.csiqu.learn.basis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/11/20
 * @since 1.0.0
 */
class SwitchStringTest {

    @Test
    void testSwitchNull() {
        Assertions.assertThrows(NullPointerException.class, () -> SwitchString.switchString(null));
    }
}