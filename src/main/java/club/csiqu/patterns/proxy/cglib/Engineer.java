package club.csiqu.patterns.proxy.cglib;

/**
 * 被代理类
 *
 * @author chensiqu
 * @since 2019/3/21 11:10
 */
class Engineer {

    void eat() {
        System.out.println("工程师正在吃饭");
        afterEat();
    }

    void afterEat() {
        System.out.println("工程师吃完饭");
    }

    /**
     * final修饰的方法不会被生成的子类覆盖
     */
    final void work() {
        System.out.println("工程师正在工作");
    }

    /**
     * private方法不会被生成的子类覆盖
     */
    private void play() {
        System.out.println("工程师在玩游戏");
    }
}