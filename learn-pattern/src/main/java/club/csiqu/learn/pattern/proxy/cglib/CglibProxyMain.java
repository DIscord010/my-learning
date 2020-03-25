package club.csiqu.learn.pattern.proxy.cglib;

/**
 * @author chensiqu
 * @since 2019/3/21 11:22
 */
public class CglibProxyMain {

    public static void main(String[] args) {
        // 获取 Engineer代理对象
        Engineer engineerProxy = CglibProxy.getProxy(new Engineer());
        engineerProxy.eat();
        engineerProxy.work();
        engineerProxy.afterEat();
        System.out.println(engineerProxy.getClass().getName());
        Researcher researcherProxy =
                CglibProxy.getProxy(new Researcher());
        researcherProxy.eat();
        researcherProxy.work();
        System.out.println(researcherProxy.getClass().getName());
    }
}