package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 简单的轮训负载均衡算法.
 *
 * @author Siqu Chen 2020/5/22
 * @since 1.0.0
 */
public class SimpleRoundRobinLoadBalance extends AbstractLoadBalance {

    private final AtomicLong atomicLong = new AtomicLong(0);

    @Override
    Invoker doSelect(List<Invoker> invokers) {
        return invokers.get((int)(atomicLong.getAndIncrement() % invokers.size()));
    }
}