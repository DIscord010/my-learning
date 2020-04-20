package club.csiqu.learn.algorithm.balance;

import java.util.List;

/**
 * @author Siqu Chen 2020/4/6
 * @since 1.0.0
 */
public abstract class BaseLoadBalance {

    abstract Invoker doSelect(List<Invoker> invokers);
}