package club.csiqu.thread.concurrent.tea;

import club.csiqu.thread.concurrent.tea.MakeTea;
import org.junit.Test;

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