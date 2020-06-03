package club.csiqu.learn.basis.jvm.oom.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 栈溢出异常验证
 * <p>
 * VM Args:-Xss128k
 *
 * @author chensiqu
 * @since 2019/7/1 22:50
 */
public class JavaStackSof {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaStackSof.class);

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaStackSof oom = new JavaStackSof();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            LOGGER.info("stackLength：{}", oom.stackLength);
            throw e;
        }
    }
}