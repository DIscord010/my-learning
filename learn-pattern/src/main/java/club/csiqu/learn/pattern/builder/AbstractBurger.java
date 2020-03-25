package club.csiqu.learn.pattern.builder;

/**
 * @author chensiqu
 * @since 2019/3/19 10:09
 */
public abstract class AbstractBurger extends AbstractItem {

    /**
     * 默认的功能 使用包装器包装
     *
     * @return 包装器
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}