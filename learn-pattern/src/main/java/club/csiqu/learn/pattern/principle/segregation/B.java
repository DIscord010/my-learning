package club.csiqu.learn.pattern.principle.segregation;

/**
 * @author chensiqu
 * @since 2019/3/13 13:52
 */
class B implements I1, I2 {

    @Override
    public void method1() {
        System.out.println("类B实现接口I1的方法1");
    }

    @Override
    public void method2() {
        System.out.println("类B实现接口I2的方法2");
    }

    @Override
    public void method3() {
        System.out.println("类B实现接口I2的方法3");
    }
}