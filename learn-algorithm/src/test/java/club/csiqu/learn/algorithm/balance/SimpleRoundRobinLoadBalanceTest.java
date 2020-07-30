package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siqu Chen 2020/5/22
 * @since 1.0
 */
class SimpleRoundRobinLoadBalanceTest {

    AbstractLoadBalance simpleRoundRobinLoadBalance = new SimpleRoundRobinLoadBalance();

    @Test
    void testSelect() {
        List<Invoker> invokers = new ArrayList<>(2);
        Invoker invoker1 = new Invoker(50, 0);
        Invoker invoker2 = new Invoker(50, 0);
        Invoker invoker3 = new Invoker(50, 0);
        Invoker invoker4 = new Invoker(50, 0);
        invokers.add(invoker1);
        invokers.add(invoker2);
        invokers.add(invoker3);
        invokers.add(invoker4);
        Assertions.assertEquals(invoker1, simpleRoundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker2, simpleRoundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker3, simpleRoundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker4, simpleRoundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker1, simpleRoundRobinLoadBalance.select(invokers));
        Assertions.assertEquals(invoker2, simpleRoundRobinLoadBalance.select(invokers));
    }
}