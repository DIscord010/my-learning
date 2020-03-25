package club.csiqu.learn.pattern.principle.dependence.car;

/**
 * @author Siqu Chen 2020/3/5
 * @since 1.0.0
 */
public class SimpleDriver implements Driver {

    @Override
    public void drive(Car car) {
        car.run();
    }
}