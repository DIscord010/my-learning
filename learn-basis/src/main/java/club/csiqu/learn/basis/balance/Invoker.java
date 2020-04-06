package club.csiqu.learn.basis.balance;

/**
 * @author Siqu Chen 2020/4/6
 * @since 1.0.0
 */
public class Invoker {

    /**
     * 权重
     */
    private Integer weigth;

    /**
     * 当前调用数
     */
    private Integer count;

    public Invoker(Integer weigth, Integer count) {
        this.weigth = weigth;
        this.count = count;
    }

    public Integer getWeigth() {
        return weigth;
    }

    public void setWeigth(Integer weigth) {
        this.weigth = weigth;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}