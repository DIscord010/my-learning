package club.csiqu.learn.basis.jvm.gc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.gc;

/**
 * 调用 finalize()方法在 GC中自我拯救验证.
 * GC销毁对象时，会调用对象的 {@code finalize()}方法.
 * 此时如果恢复引用，则可以避免对象被回收，{@code finalize()}只会被执行一次.
 *
 * @author chensiqu
 * @since 2019/7/2 23:01
 */
public class EscapeApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscapeApplication.class);

    private static EscapeApplication finalizeEscapeGc = null;

    private void isAlive() {
        LOGGER.info("finalizeEscapeGc is alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        LOGGER.info("Method finalize() executed!");
        finalizeEscapeGc = this;
    }

    public static void main(String[] args) throws InterruptedException {
        finalizeEscapeGc = new EscapeApplication();
        finalizeEscapeGc = null;
        gc();
        // finalize()方法优先级很低，暂停 0.5秒等待
        Thread.sleep(500);
        if (finalizeEscapeGc != null) {
            finalizeEscapeGc.isAlive();
        } else {
            LOGGER.info("finalizeEscapeGc is dead.");
        }

        finalizeEscapeGc = null;
        gc();
        Thread.sleep(500);
        // 此时，对象被回收因为 finalize()方法只会被调用一次
        if (finalizeEscapeGc != null) {
            finalizeEscapeGc.isAlive();
        } else {
            LOGGER.info("No, finalizeEscapeGc is dead.");
        }
    }
}