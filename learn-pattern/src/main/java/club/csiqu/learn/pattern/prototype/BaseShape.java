package club.csiqu.learn.pattern.prototype;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 11:59
 */
public abstract class BaseShape implements Cloneable {

    private String id;

    String type;

    abstract void draw();

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}