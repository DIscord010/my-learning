package club.csiqu.framework.spring.tiny.aop;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/21 10:14
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return new Cglib2AopProxy(this);
    }
}