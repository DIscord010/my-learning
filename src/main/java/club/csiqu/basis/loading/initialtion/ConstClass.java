package club.csiqu.basis.loading.initialtion;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:26
 */
class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    static final String HELLOWORLD = "hello world！";
}