package club.csiqu.learn.pattern.principle.liskov;

/**
 * 子类增加功能时不能覆写父类的非抽象方法
 */
class Son extends Father {

    @Override
    int func(int a, int b) {
        return a - b + 100;
    }
}