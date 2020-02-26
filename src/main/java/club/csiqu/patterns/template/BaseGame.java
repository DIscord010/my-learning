package club.csiqu.patterns.template;

/**
 * 模板设计模式
 * <p>
 * 定义一些抽象方法，但是调用这些方法的方法由抽象类定义。
 * 即子类实现具体的方法，但是如何调用这些方法由抽象类定义。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:15
 */
abstract class BaseGame {

    /**
     * 初始化
     */
    abstract void init();

    /**
     * 开始游戏
     */
    abstract void startGame();

    /**
     * 结束游戏
     */
    abstract void endGame();

    /**
     * 如何调用由父类实现。且申明为 {@code final}不允许子类覆写。
     */
    final void play() {
        init();
        startGame();
        endGame();
    }
}