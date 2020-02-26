package club.csiqu.basis.jvm.javassist;

import javassist.*;

/**
 * Javassist实现字节码增强
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 16:36
 */
public class JavassistMain {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {

        // JVM不允许在运行时动态重载一个类的
        // 增加下方代码抛出 LinkageError: attempted  duplicate class definition for name
        //Base b = new Base();

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("org.chensiqu.basis.jvm.javassist.Base");
        CtMethod m = cc.getDeclaredMethod("process");

        m.insertBefore("{ System.out.println(\"start\");}");
        m.insertAfter("{ System.out.println(\"end\");}");

        Class c = cc.toClass();

        Base base = (Base) c.newInstance();
        base.process();
    }
}