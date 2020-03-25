package club.csiqu.learn.pattern.template.tea;

/**
 * @author Siqu Chen 2020/3/10
 * @since 1.0.0
 */
public class GreenTeaProvider extends BaseTeaProvider {

    @Override
    protected void getTea() {
        System.out.println("获取绿茶");
    }

    @Override
    protected void preparingTeaSet() {
        System.out.println("准备并清洗茶具");
    }

    @Override
    protected void makeTea() {
        System.out.println("绿茶泡五分钟");
    }
}