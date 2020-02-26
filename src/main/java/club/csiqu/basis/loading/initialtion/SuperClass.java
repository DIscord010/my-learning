package club.csiqu.basis.loading.initialtion;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:20
 */
class SuperClass {

    static {
        System.out.println("superClass init!");
    }

    static int value = 123;
}