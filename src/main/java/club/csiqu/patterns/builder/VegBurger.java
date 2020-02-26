package club.csiqu.patterns.builder;

/**
 * @author chensiqu
 * @since 2019/3/19 10:15
 */
public class VegBurger extends AbstractBurger {

    @Override
    public String name() {
        return "Veg AbstractBurger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}