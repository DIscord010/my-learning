package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;

import java.util.List;

/**
 * @author Siqu Chen 2020/4/6
 * @since 1.0
 */
public abstract class AbstractLoadBalance {

    public Invoker select(List<Invoker> invokers) {
        if (invokers == null || invokers.isEmpty()) {
            return null;
        }
        if (invokers.size() == 1) {
            return invokers.get(0);
        }
        return doSelect(invokers);
    }

    /**
     * 负载均衡实现
     *
     * @param invokers 调用者
     * @return 从调用者集合中选择一个调用者
     */
    abstract Invoker doSelect(List<Invoker> invokers);
}