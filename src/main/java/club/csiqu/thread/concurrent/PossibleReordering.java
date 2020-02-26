package club.csiqu.thread.concurrent;

/**
 * 指令重排序的研究。
 * 会出现结果为 x=0, y=0的情况说明发生了指令重排序。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/9
 */
public class PossibleReordering {

    private static int x = 0, y = 0;

    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                // 先运行需要等待一会与线程 two同步
                shortWait();
                a = 1;
                x = b;
            });
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            two.start();
            one.join();
            two.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }

    private static void shortWait() {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + (long) 100000 >= end);
    }
}