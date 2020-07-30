package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 简单实现最小活跃数负载均衡，存在唯一最小活跃数 {@code invoker}则为目标，不唯一则直接使用随机算法。
 *
 * @author Siqu Chen 2020/4/19
 * @since 1.0
 */
public class LeastActiveLoadBalance extends AbstractLoadBalance {

    @Override
    Invoker doSelect(List<Invoker> invokers) {
        int length = invokers.size();
        // 记录最小活跃数的 invoker的下标
        int[] leastIndexArray = new int[length];
        int leastActive = -1;
        // 为最小活跃数的 invoker个数
        int leastCount = 0;
        for (int i = 0; i < length; i++) {
            Invoker invoker = invokers.get(i);
            int active = invoker.getCount();
            if (leastActive == -1 || active < leastActive) {
                leastActive = active;
                // 此时需要重置计数
                leastCount = 1;
                leastIndexArray[0] = i;
            } else if (active == leastActive) {
                leastIndexArray[leastCount++] = i;
            }
        }
        if (leastCount == 1) {
            return invokers.get(leastIndexArray[0]);
        } else {
            // [0,leastCount)
            int index = ThreadLocalRandom.current().nextInt(leastCount);
            return invokers.get(leastIndexArray[index]);
        }
    }
}