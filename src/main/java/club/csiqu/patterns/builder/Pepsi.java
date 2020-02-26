package club.csiqu.patterns.builder;

/**
 * @author chensiqu
 * @since 2019/3/19 10:19
 */
public class Pepsi extends AbstractColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}