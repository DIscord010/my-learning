package club.csiqu.learn.structure.set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siqu Chen 2020/4/7
 * @since 1.0.0
 */
class BitSetTest {

    @Test
    public void testBitSet() {
        BitSet bitSet = new BitSet(100);
        bitSet.set(100);
        assertTrue(bitSet.get(100));
        bitSet.set(2);
        assertTrue(bitSet.get(2));
    }
}