package club.csiqu.learn.pattern.factory;

/**
 * @author Siqu Chen 2020/9/11
 * @since 1.0
 */
public class LinuxButton implements Button {

    @Override
    public String render() {
        return "Render a button in a Linux style";
    }
}