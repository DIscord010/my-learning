package club.csiqu.learn.basis.jvm.oom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 栈溢出异常验证
 * <p>
 * VM Args:-Xss128K
 *
 * @author chensiqu
 * @since 2019/7/1 22:50
 */
public class JavaStackSofApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaStackSofApplication.class);

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaStackSofApplication oom = new JavaStackSofApplication();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            LOGGER.info("stackLength：{}", oom.stackLength);
            throw e;
        }
    }
}