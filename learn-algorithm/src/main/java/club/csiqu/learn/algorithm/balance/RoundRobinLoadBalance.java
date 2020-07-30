package club.csiqu.learn.algorithm.balance;

import club.csiqu.learn.algorithm.balance.model.Invoker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 带权重的轮训负载均衡算法.
 * 例如 [A, B, C]权重为 [8, 1, 1]，则十次调用，次数比为 [8: 1: 1].
 *
 * @author Siqu Chen 2020/5/22
 * @since 1.0
 */
public class RoundRobinLoadBalance extends AbstractLoadBalance {

    private final Map<String, WeightedRoundRobin> weightedRoundRobinMap = new ConcurrentHashMap<>(16);

    private static final int RECYCLE_PERIOD = 60000;

    private static class WeightedRoundRobin {

        private final AtomicLong current = new AtomicLong(0);

        private int weight;

        private long lastUpdate;

        public long increaseCurrent() {
            return current.addAndGet(weight);
        }

        public void reset(int total) {
            current.addAndGet(-1L * total);
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public long getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(long lastUpdate) {
            this.lastUpdate = lastUpdate;
        }
    }

    @Override
    Invoker doSelect(List<Invoker> invokers) {
        long currentMax = Long.MIN_VALUE;
        long now = System.currentTimeMillis();
        int totalWeight = 0;
        Invoker selectedInvoker = null;
        WeightedRoundRobin selectedWeightedRoundRobin = null;
        for (Invoker invoker : invokers) {
            int weight = invoker.getWeight();
            WeightedRoundRobin weightedRoundRobin = weightedRoundRobinMap.computeIfAbsent(invoker.toString(), k -> {
                        WeightedRoundRobin wrr = new WeightedRoundRobin();
                        wrr.setWeight(weight);
                        return wrr;
                    }
            );
            if (weight != weightedRoundRobin.getWeight()) {
                weightedRoundRobin.setWeight(weight);
            }
            long current = weightedRoundRobin.increaseCurrent();
            weightedRoundRobin.setLastUpdate(now);
            if (current > currentMax) {
                currentMax = current;
                selectedInvoker = invoker;
                selectedWeightedRoundRobin = weightedRoundRobin;
            }
            totalWeight += weight;
        }
        // 回收 30s未活动的 weightedRoundRobin
        if (invokers.size() != weightedRoundRobinMap.size()) {
            weightedRoundRobinMap.entrySet().removeIf(item -> now - item.getValue().getLastUpdate() > RECYCLE_PERIOD);
        }
        if (selectedInvoker != null) {
            selectedWeightedRoundRobin.reset(totalWeight);
            return selectedInvoker;
        }
        // 正常不会执行到这里
        return invokers.get(0);
    }
}