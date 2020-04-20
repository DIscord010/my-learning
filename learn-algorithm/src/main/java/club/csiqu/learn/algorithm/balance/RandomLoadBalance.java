package club.csiqu.learn.algorithm.balance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Siqu Chen 2020/4/6
 * @since 1.0.0
 */
public class RandomLoadBalance extends BaseLoadBalance {

    @Override
    Invoker doSelect(List<Invoker> invokers) {
        boolean sameWeight = true;
        int firstWeight = invokers.get(0).getWeigth();
        int totalWeight = firstWeight;
        for (int i = 1; i < invokers.size(); i++) {
            int weight = invokers.get(i).getWeigth();
            totalWeight += invokers.get(i).getWeigth();
            if (sameWeight && firstWeight != weight) {
                sameWeight = false;
            }
        }
        if (!sameWeight && totalWeight > 0) {
            int offset = ThreadLocalRandom.current().nextInt(totalWeight);
            for (Invoker invoker : invokers) {
                offset -= invoker.getWeigth();
                if (offset < 0) {
                    return invoker;
                }
            }
        }
        return invokers.get(ThreadLocalRandom.current().nextInt(totalWeight));
    }
}