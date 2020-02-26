package club.csiqu.patterns.template;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:21
 */
class Football extends BaseGame {

    @Override
    void init() {
        System.out.println("Football game init.");
    }

    @Override
    void startGame() {
        System.out.println("Football game start.");
    }

    @Override
    void endGame() {
        System.out.println("Football game end.");
    }
}