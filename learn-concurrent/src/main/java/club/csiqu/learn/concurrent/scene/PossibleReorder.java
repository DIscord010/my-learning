package club.csiqu.learn.concurrent.scene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指令重排序的研究。
 * 会出现结果为 x=0, y=0的情况说明发生了指令重排序。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/9
 */
public class PossibleReorder {

    private static final Logger LOGGER = LoggerFactory.getLogger(PossibleReorder.class);

    int x = 0;

    int y = 0;

    int a = 0;

    int b = 0;

    /**
     * 当出现 x=0，y=0的情况可以说明发生了指令重排序
     */
    public void reordering() throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread thread0 = new Thread(() -> {
                // 稍微等待一会
                shortWait();
                a = 1;
                x = b;
            });
            Thread thread1 = new Thread(() -> {
                b = 1;
                y = a;
            });
            thread0.start();
            thread1.start();
            thread0.join();
            thread1.join();

            if (x == 0 && y == 0) {
                LOGGER.debug("第{}次 ({},{})", i, x, y);
                break;
            } else {
                LOGGER.debug("第{}次 ({},{})", i, x, y);
            }
        }
    }

    private static void shortWait() {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + (long)100000 >= end);
    }
}