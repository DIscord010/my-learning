package club.csiqu.learn.framework.dubbo.model;

import java.io.Serializable;

/**
 * @author Siqu Chen 2020/9/11
 * @since 1.0
 */
public class BaseReq<T> implements Serializable {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}