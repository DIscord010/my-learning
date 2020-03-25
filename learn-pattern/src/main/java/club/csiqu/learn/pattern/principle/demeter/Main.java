package club.csiqu.learn.pattern.principle.demeter;

/**
 * 迪米特法则，又叫最少知道原则。
 * 一个对象应该对其他对象保持最少的了解。
 * <p>
 * 一个类对自己依赖的类知道的越少越好。
 * 就是说，对于被依赖的类来说，无论逻辑多么复杂，都尽量地的将逻辑封装在类的内部，
 * 对外除了提供的 public方法，不对外泄漏任何信息。
 *
 * @author chensiqu
 * @since 2019/3/13 10:01
 */
public class Main {

    public static void main(String[] args) {
        CompanyManager e = new CompanyManager();
        e.printAllEmployee(new SubCompanyManager());
    }
}