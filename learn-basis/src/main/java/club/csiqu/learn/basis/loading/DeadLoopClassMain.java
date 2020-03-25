package club.csiqu.learn.basis.loading;

/**
 * 验证虚拟机保证在多线程同时初始化一个类的情况下，
 * 只有会一个线程执行这个类的 {@code <clinit>()}方法，其他线程需要阻塞等待。
 *
 * @author chensiqu
 * @since 2019/5/5 22:35
 */
public class DeadLoopClassMain {

    @SuppressWarnings({"ConstantConditions", "InfiniteLoopStatement", "StatementWithEmptyBody"})
    private static class DeadLoopClass {
        static {
            if (true) {
                System.out.println(Thread.currentThread() + " init " +
                        "DeadLoopClass");
                while (true) {

                }
            }
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Runnable script = () -> {
            System.out.println(Thread.currentThread() + " start");
            // 触发类的初始化，观察在多线程情况下如何执行
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };
        new Thread(script, "线程 1").start();
        new Thread(script, "线程 2").start();
    }
}