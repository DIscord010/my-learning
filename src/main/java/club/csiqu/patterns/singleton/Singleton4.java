package club.csiqu.patterns.singleton;

/**
 * 双重锁机制
 * <p>
 * {@code instance = new Singleton4();}这一行代码
 * 实际上是由三步操作（多条指令，具体条数未研究。线程切换可能发生在任意指令之后）完成：
 * 1、分配内存空间
 * 2、初始化对象
 * 3、{@code instance}指向内存空间
 * <p>
 * 如果未加 {@code volatile}关键字，则可能发生指令重排序，执行步骤可能为 1->3->2。
 * 那么 {@code instance == null}这个条件判断对象是否初始化时，因为步骤 3已经完成，但是实际上仍然在进行步骤 2，
 * 导致空指针异常。
 *
 * @author chensiqu
 * @since 2019/3/19 9:34
 */
public class Singleton4 {

    private static volatile Singleton4 instance;

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

    private Singleton4() {
    }
}