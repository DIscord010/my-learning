package club.csiqu.learn.basis.jvm.bytecode.javassist;

import club.csiqu.learn.basis.jvm.bytecode.PrintProcess;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * Javassist实现字节码增强
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 16:36
 */
public class JavassistApplication {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {

        // JVM不允许在运行时重新加载类
        // 增加下方代码抛出 LinkageError: attempted  duplicate class definition for name
        //Base b = new Base();

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get(PrintProcess.CLASS_REFERENCE);
        CtMethod m = cc.getDeclaredMethod("process");

        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");

        Class<?> c = cc.toClass();

        PrintProcess base = (PrintProcess)c.newInstance();
        base.process();
    }
}