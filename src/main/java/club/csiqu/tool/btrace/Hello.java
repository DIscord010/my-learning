package club.csiqu.tool.btrace;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/2 9:36
 */
public class Hello {

    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Hello hello = new Hello();
        while (true) {
            hello.sayHello("chen");
        }
    }
}