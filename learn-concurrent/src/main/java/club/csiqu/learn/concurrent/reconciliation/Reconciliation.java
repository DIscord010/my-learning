package club.csiqu.learn.concurrent.reconciliation;

/**
 * @author chensiqu 2019/12/25
 * @since 1.0.0
 */
public interface Reconciliation {

    /**
     * 对账
     *
     * @throws InterruptedException 线程中断异常
     */
    void reconciliation() throws InterruptedException;
}