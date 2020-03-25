package club.csiqu.learn.concurrent;

import java.util.Vector;

/**
 * 对 Vector线程安全的测试
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/15 22:52
 */
@SuppressWarnings({"InfiniteLoopStatement", "StatementWithEmptyBody", "SuspiciousListRemoveInLoop"})
public class VectorMain {

    private static Vector<Integer> vector = new Vector<>();


    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread remove = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread print = new Thread(() -> {
                for (Integer integer : vector) {
                    System.out.println(integer);
                }
            });

            remove.start();
            print.start();

            // 防止产生过多的线程
            while (Thread.activeCount() > 20) {
            }
        }

    }
}