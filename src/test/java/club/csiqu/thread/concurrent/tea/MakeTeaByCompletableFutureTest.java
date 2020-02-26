package club.csiqu.thread.concurrent.tea;

import club.csiqu.thread.concurrent.tea.MakeTeaByCompletableFuture;
import org.junit.Test;

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