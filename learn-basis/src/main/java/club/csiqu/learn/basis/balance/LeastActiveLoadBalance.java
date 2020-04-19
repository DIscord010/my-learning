package club.csiqu.learn.basis.balance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 简单实现最小活跃数负载均衡，存在唯一最小活跃数{@code invoker}则为目标，不唯一则直接使用随机算法。
 *
 * @author Siqu Chen 2020/4/19
 * @since 1.0.0
 */
public class LeastActiveLoadBalance extends BaseLoadBalance {

    @Override
    Invoker doSelect(List<Invoker> invokers) {
        int lenght = invokers.size();
        // 记录最小活跃数的 invoker的下标
        int[] leastIndexs = new int[lenght];
        int leastActice = -1;
        // 为最小活跃数的 invoker个数
        int leastCount = 0;
        for (int i = 0; i < lenght; i++) {
            Invoker invoker = invokers.get(i);
            int active = invoker.getCount();
            if (leastActice == -1 || active < leastActice) {
                leastActice = active;
                // 此时需要重置计数
                leastCount = 1;
                leastIndexs[0] = i;
            } else if (active == leastActice) {
                leastIndexs[leastCount++] = i;
            }
        }
        if (leastCount == 1) {
            return invokers.get(leastIndexs[0]);
        } else {
            int index = ThreadLocalRandom.current().nextInt(leastCount);
            return invokers.get(leastIndexs[index]);
        }
    }
}