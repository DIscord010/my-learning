package club.csiqu.patterns.template.tea;

/**
 * @author Siqu Chen 2020/3/10
 * @since 1.0.0
 */
public class TeaProviderMain {

    public static void main(String[] args) {
        BaseTeaProvider redTea = new RedTeaProvider();
        redTea.tea();

        BaseTeaProvider greenTea = new GreenTeaProvider();
        greenTea.tea();
    }
}