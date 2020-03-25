package club.csiqu.learn.pattern.principle.segregation;

/**
 * @author chensiqu
 * @since 2019/3/13 13:52
 */
class C {

    void depend1(I1 i) {
        i.method1();
    }

    void depend2(I3 i) {
        i.method4();
    }

    void depend3(I3 i) {
        i.method5();
    }
}