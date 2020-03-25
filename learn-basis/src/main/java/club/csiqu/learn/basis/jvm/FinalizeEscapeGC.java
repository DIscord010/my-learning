package club.csiqu.learn.basis.jvm;

/**
 * 调用 finalize()方法在 GC中自我拯救验证
 *
 * @author chensiqu
 * @since 2019/7/2 23:01
 */
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void isAlive() {
        System.out.println("yes, i am still alive.");
    }

    @Override
    protected void finalize() throws Throwable {

        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;

        System.gc();

        // finalize()方法优先级很低，暂停 0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead.");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        // 此时，对象被回收因为 finalize()方法只会被调用一次
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead.");
        }
    }
}