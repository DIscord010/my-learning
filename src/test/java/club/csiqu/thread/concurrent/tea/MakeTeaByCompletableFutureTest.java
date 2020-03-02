package club.csiqu.thread.concurrent.tea;

import org.junit.jupiter.api.Test;

/**
 * @author chensiqu 2019/12/19
 * @since 1.0.0
 */
public class MakeTeaByCompletableFutureTest {

    @Test
    public void makeTea() {
        MakeTeaByCompletableFuture makeTeaByCompletableFuture = new MakeTeaByCompletableFuture();
        makeTeaByCompletableFuture.makeTea();
    }
}