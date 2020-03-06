package club.csiqu.thread.concurrent.reconciliation;


import org.junit.jupiter.api.Test;

/**
 * @author chensiqu 2019/12/27
 * @since 1.0.0
 */
public class ReconciliationTest {

    Reconciliation reconciliation00 = new Reconciliation00();

    Reconciliation reconciliation01 = new Reconciliation01();

    Reconciliation reconciliation10 = new Reconciliation10();

    Reconciliation reconciliation11 = new Reconciliation11();

    @Test
    public void test00() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reconciliation00.reconciliation();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("对账1000次所花时间: " + (endTime - startTime) + "ms");
    }

    @Test
    public void test01() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reconciliation01.reconciliation();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("对账1000次所花时间: " + (endTime - startTime) + "ms");
    }

    @Test
    public void test10() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reconciliation10.reconciliation();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("对账1000次所花时间: " + (endTime - startTime) + "ms");
    }

    @Test
    public void test11() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            reconciliation11.reconciliation();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("对账1000次所花时间: " + (endTime - startTime) + "ms");
    }
}