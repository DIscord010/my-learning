package club.csiqu.learn.algorithm.balance.model;

/**
 * @author Siqu Chen 2020/4/6
 * @since 1.0
 */
public class Invoker {

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 当前调用数
     */
    private Integer count;

    public Invoker(Integer weight, Integer count) {
        this.weight = weight;
        this.count = count;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weigth) {
        this.weight = weigth;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}