package club.csiqu.patterns.builder;

/**
 * @author chensiqu
 * @since 2019/3/19 10:13
 */
public abstract class AbstractColdDrink extends AbstractItem {


    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}