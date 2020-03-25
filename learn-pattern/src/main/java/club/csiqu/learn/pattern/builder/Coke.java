package club.csiqu.learn.pattern.builder;

/**
 * @author chensiqu
 * @since 2019/3/19 10:18
 */
public class Coke extends AbstractColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}