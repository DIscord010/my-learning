package club.csiqu.framework.spring.tiny.aop;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 11:22
 */
abstract class AbstractAopProxy implements AopProxy {

    AdvisedSupport advised;

    AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}