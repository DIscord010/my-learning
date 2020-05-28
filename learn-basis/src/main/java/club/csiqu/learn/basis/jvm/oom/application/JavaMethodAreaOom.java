package club.csiqu.learn.basis.jvm.oom.application;

import club.csiqu.learn.basis.jvm.oom.OomObject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 使用 CGLib动态生成类文件，导致方法区溢出
 * <p>
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M(JDK 1.7之前)
 * JDK 1.7或之前的版本中会产生 java.lang.OutOfMemoryError:PermGen space异常。
 * <p>
 * VM Args:-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M(JDK 1.8)
 * 在 1.8之后，使用元空间 (MetaSpace)永久的代替代了永久代；和堆也是不相连。
 *
 * @author chensiqu
 * @since 2019/7/1 22:57
 */
public class JavaMethodAreaOom {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OomObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, arg1, args1, proxy)
                    -> proxy.invokeSuper(obj, args1));
            OomObject oom = (OomObject)enhancer.create();
            oom.getOom();
        }
    }
}