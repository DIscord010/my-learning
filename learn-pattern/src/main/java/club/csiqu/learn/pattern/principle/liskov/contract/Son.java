package club.csiqu.learn.pattern.principle.liskov.contract;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/10 12:55
 */
class Son extends Father {

    /**
     * 缩小输入参数类型
     *
     * @param map {@link Map}
     * @return {@link Collection}
     */
    Collection<?> doSomething(HashMap<?,?> map) {
        System.out.println("子类被执行...");
        return map.values();
    }
}