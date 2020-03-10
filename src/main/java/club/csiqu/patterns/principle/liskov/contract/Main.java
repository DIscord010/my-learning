package club.csiqu.patterns.principle.liskov.contract;

import java.util.HashMap;

/**
 * 在重载的时候，要求方法的输入类型或者参数数量不相同。
 * 在里氏替换原则的要求（父类能存在的地方，子类也一定可以存在）下，则子类的输入参数要宽于父类的输入参数。否则就会出现如下场景：
 * 在父类存在的地方替换为子类后结果不同。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/10 13:15
 */
public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>(16) {
            {
                put("key", 123);
            }
        };
        Father father = new Father();
        System.out.println(father.doSomething(hashMap));
        Son son = new Son();
        System.out.println(son.doSomething(hashMap));
    }
}