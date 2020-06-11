package club.csiqu.learn.concurrent.scene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/6/11
 * @since 1.0.0
 */
class PossibleReorderingTest {

    @Test
    void testReordering() throws InterruptedException {
        PossibleReorder possibleReordering = new PossibleReorder();
        possibleReordering.reordering();
        Assertions.assertEquals(0, possibleReordering.x);
    }

}