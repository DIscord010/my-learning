package club.csiqu.patterns.principle.segregation;

/**
 * 依赖I1，I2
 */
class A {

    void depend1(I1 i) {
        i.method1();
    }

    void depend2(I2 i) {
        i.method2();
    }

    void depend3(I2 i) {
        i.method3();
    }

}