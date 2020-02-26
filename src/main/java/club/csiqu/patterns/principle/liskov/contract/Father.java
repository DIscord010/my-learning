package club.csiqu.patterns.principle.liskov.contract;

import java.util.Collection;
import java.util.Map;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/10 12:53
 */
class Father {

    Collection doSomething(Map map) {

        System.out.println("父类被执行...");
        return map.values();
    }
}