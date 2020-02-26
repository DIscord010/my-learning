package club.csiqu.patterns.template;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:20
 */
class Cricket extends BaseGame {

    @Override
    void init() {
        System.out.println("Cricket game init.");
    }

    @Override
    void startGame() {
        System.out.println("Cricket game start.");
    }

    @Override
    void endGame() {
        System.out.println("Cricket game end.");
    }
}