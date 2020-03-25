package club.csiqu.learn.framework.rpc.tiny.model;

import java.io.Serializable;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 15:05
 */
public class RpcTransfer implements Serializable {

    private static final long serialVersionUID = 9075459194564622461L;

    /** 调用的接口 */
    private String clazzName;

    /** 调用的方法 */
    private String methodName;

    /** 方法的参数类型 */
    private Class<?>[] clazzs;

    /** 方法参数 */
    private Object[] args;

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getClazzs() {
        return clazzs;
    }

    public void setClazzs(Class<?>[] clazzs) {
        this.clazzs = clazzs;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}