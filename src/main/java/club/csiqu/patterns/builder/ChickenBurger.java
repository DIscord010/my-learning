package club.csiqu.patterns.builder;

/**
 * @author chensiqu
 * @since 2019/3/19 10:17
 */
public class ChickenBurger extends AbstractBurger {

    @Override
    public String name() {
        return "Chicken AbstractBurger";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}