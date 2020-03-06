package club.csiqu.patterns.principle.dependence.car;

/**
 * @author Siqu Chen 2020/3/5
 * @since 1.0.0
 */
public class DriverMain {

    public static void main(String[] args) {
        Driver driver = new SimpleDriver();
        driver.drive(new Benz());
    }
}