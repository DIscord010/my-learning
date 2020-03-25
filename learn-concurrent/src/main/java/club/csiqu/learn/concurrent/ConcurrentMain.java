package club.csiqu.learn.concurrent;

/**
 * 验证多核场景下的并发问题
 *
 * @author chensiqu
 * @since 2019/3/26 9:33
 */
public class ConcurrentMain {

    private long count = 0;

    private void add10k() {
        int index = 0;
        while (index++ < 10000) {
            count += 1;
        }
    }

    private long calc() throws InterruptedException {
        // 创建两个线程执行 add10()方法
        Thread th1 = new Thread(this::add10k);
        Thread th2 = new Thread(this::add10k);
        // 启动线程
        th1.start();
        th2.start();

        th1.join();
        th2.join();
        // 等两个线程执行完成后返回
        return this.count;
    }

    /**
     * 可见性原因：线程 A和线程 B同时开始执行，那么第一次都会将 count=0读到各自的缓存，执行完 count+=1后，
     * 各自的 cpu缓存中 count都是 1，同时写入内存后内存中 count为 1，而不是我们期望的 2。
     * 原子性原因：count+=1需要三条指令，而操作系统做任务切换可能发生在任意一条指令执行完成后。
     *
     * @param args 主函数入口
     */
    public static void main(String[] args) {
        ConcurrentMain visibilityTest = new ConcurrentMain();
        try {
            long count = visibilityTest.calc();
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}