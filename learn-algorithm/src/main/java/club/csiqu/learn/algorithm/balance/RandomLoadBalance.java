package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 按权重随机的负载均衡算法。
 *
 * @author Siqu Chen 2020/4/6
 * @since 1.0.0
 */
public class RandomLoadBalance extends AbstractLoadBalance {

    @Override
    Invoker doSelect(List<Invoker> invokers) {
        boolean sameWeight = true;
        int firstWeight = invokers.get(0).getWeight();
        int totalWeight = firstWeight;
        for (int i = 1; i < invokers.size(); i++) {
            int weight = invokers.get(i).getWeight();
            totalWeight += invokers.get(i).getWeight();
            if (sameWeight && firstWeight != weight) {
                sameWeight = false;
            }
        }
        if (!sameWeight && totalWeight > 0) {
            int offset = ThreadLocalRandom.current().nextInt(totalWeight);
            for (Invoker invoker : invokers) {
                offset -= invoker.getWeight();
                if (offset < 0) {
                    return invoker;
                }
            }
        }
        return invokers.get(ThreadLocalRandom.current().nextInt(totalWeight));
    }
}