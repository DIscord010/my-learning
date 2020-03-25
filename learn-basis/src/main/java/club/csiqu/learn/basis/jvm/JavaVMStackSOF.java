package club.csiqu.learn.basis.jvm;

/**
 * 栈溢出异常验证
 * <p>
 * VM Args:-Xss128k
 *
 * @author chensiqu
 * @since 2019/7/1 22:50
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    @SuppressWarnings("InfiniteRecursion")
    private void stackLeak() {

        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}