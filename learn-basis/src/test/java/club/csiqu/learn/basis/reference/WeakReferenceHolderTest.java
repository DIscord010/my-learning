package club.csiqu.learn.basis.reference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/8/19
 * @since 1.0
 */
class WeakReferenceHolderTest {

    private final WeakReferenceHolder weakReferenceHolder = new WeakReferenceHolder();

    @Test
    void testWeakReference() {
        Assertions.assertEquals(55555, weakReferenceHolder.integer.get());
        System.gc();
        Assertions.assertNull(weakReferenceHolder.integer.get());
    }
}