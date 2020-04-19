package club.csiqu.learn.basis.balance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Siqu Chen 2020/4/19
 * @since 1.0.0
 */
class LeastActiveLoadBalanceTest {

    BaseLoadBalance random = new LeastActiveLoadBalance();

    @Test
    void doSelect() {
        List<Invoker> invokers = new ArrayList<>(2);
        Invoker invoker1 = new Invoker(100, 10);
        Invoker invoker2 = new Invoker(100, 50);
        Invoker invoker3 = new Invoker(100,20);
        invokers.add(invoker1);
        invokers.add(invoker2);
        invokers.add(invoker3);
        assertEquals(invoker1, random.doSelect(invokers));
    }
}