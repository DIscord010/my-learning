package club.csiqu.thread.concurrent.tea;

import org.junit.jupiter.api.Test;

/**
 * @author chensiqu 2019/12/30
 * @since 1.0.0
 */
public class MakeTeaTest {

    @Test
    public void makeTea() throws InterruptedException {
        MakeTea makeTea = new MakeTea();
        makeTea.serialMakeTea();
    }
}