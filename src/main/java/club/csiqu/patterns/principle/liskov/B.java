package club.csiqu.patterns.principle.liskov;

/**
 * 子类增加功能时不能覆写父类的非抽象方法
 */
class B extends A {

    int funcB(int a, int b) {
        return a - b + 100;
    }
}