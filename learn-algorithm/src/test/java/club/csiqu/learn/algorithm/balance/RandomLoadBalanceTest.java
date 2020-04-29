package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siqu Chen 2020/4/6
 * @since 1.0.0
 */
class RandomLoadBalanceTest {

    BaseLoadBalance random = new RandomLoadBalance();

    @Test
    void doSelect() {
        List<Invoker> invokers = new ArrayList<>(2);
        Invoker invoker1 = new Invoker(100,0);
        Invoker invoker2 = new Invoker(0,0);
        invokers.add(invoker1);
        invokers.add(invoker2);
        Assertions.assertEquals(invoker1,random.select(invokers));
    }
}