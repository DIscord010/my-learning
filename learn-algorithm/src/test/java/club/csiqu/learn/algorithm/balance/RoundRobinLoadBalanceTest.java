package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siqu Chen 2020/5/25
 * @since 1.0
 */
class RoundRobinLoadBalanceTest {

    AbstractLoadBalance roundRobinLoadBalance = new RoundRobinLoadBalance();

    @Test
    void testSelect() {
        List<Invoker> invokers = new ArrayList<>(2);
        Invoker invoker1 = new Invoker(80, 0);
        Invoker invoker2 = new Invoker(10, 0);
        Invoker invoker3 = new Invoker(10, 0);
        invokers.add(invoker1);
        invokers.add(invoker2);
        invokers.add(invoker3);
        // [A, B, C]权重为 [80, 10, 10].那么调用十次结果为：A A A B A A C A A A
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker2, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));

        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker3, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, roundRobinLoadBalance.select(invokers));
    }
}