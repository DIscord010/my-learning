package club.csiqu.learn.basis.jvm.oom;

/**
 * @author Siqu Chen 2020/5/27
 * @since 1.0.0
 */
public class OomObject {

    private String oom;

    public OomObject() {
    }

    public OomObject(String oom) {
        this.oom = oom;
    }

    public String getOom() {
        return oom;
    }

    public void setOom(String oom) {
        this.oom = oom;
    }
}