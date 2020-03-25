package club.csiqu.learn.pattern.proxy.cglib;

/**
 * @author chensiqu
 * @since 2019/3/21 11:26
 */
class Researcher {

    void eat() {
        System.out.println("研究员正在吃饭");
    }

    /**
     * final修饰的方法不会被生成的子类覆盖
     */
    final void work() {
        System.out.println("研究员正在工作");
    }

    /**
     * private方法不会被生成的子类覆盖
     */
    private void play() {
        System.out.println("研究员在玩游戏");
    }
}