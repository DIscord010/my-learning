package club.csiqu.learn.concurrent.thread;

/**
 * 测试锁的产生
 *
 * @author chensiqu
 * @since 2019/4/8 17:15
 */
public class SyncAddMain implements Runnable {

    private int a, b;

    private SyncAddMain(int a, int b) {
        this.a = b;
        this.b = a;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncAddMain(1, 2)).start();
            new Thread(new SyncAddMain(2, 1)).start();
        }
    }
}