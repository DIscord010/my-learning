package club.csiqu.patterns.template.tea;

/**
 * @author Siqu Chen 2020/3/9
 * @since 1.0.0
 */
public abstract class BaseTeaProvider {

    public final void tea() {
        getTea();
        preparingTeaSet();
        makeTea();
    }

    /** 获取茶叶 */
    protected abstract void getTea();

    /** 准备茶具 */
    protected abstract void preparingTeaSet();

    /** 泡茶 */
    protected abstract void makeTea();
}