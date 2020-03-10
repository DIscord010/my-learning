package club.csiqu.patterns.template.tea;

/**
 * @author Siqu Chen 2020/3/10
 * @since 1.0.0
 */
public class RedTeaProvider extends BaseTeaProvider {

    @Override
    protected void getTea() {
        System.out.println("获取红茶");
    }

    @Override
    protected void preparingTeaSet() {
        System.out.println("清洗茶具");
    }

    @Override
    protected void makeTea() {
        System.out.println("红茶泡十分钟");
    }
}