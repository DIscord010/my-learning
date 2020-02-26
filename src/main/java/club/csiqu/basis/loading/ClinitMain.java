package club.csiqu.basis.loading;

/**
 * 类初始化顺序。
 * 生成 {@code <clinit>()}（编译器自动收集类中的所有的类变量初始化语句和静态语句块生成）方法，
 * 不是必须的，没有静态语言块，也没有对类变量的赋值操作的话。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/26 20:38
 */
public class ClinitMain {

    static class Parent {

        @SuppressWarnings("UnusedAssignment")
        static int A = 1;

        static {
            A = 2;
            System.out.println(12312321);
        }
    }

    static class Sub extends Parent {

        static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}