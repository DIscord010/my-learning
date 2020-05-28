package club.csiqu.learn.basis.jvm.bytecode.asm.application;

import club.csiqu.learn.basis.jvm.bytecode.asm.MyClassVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 15:44
 */
public class AsmGenerator {

    private static final String CLASS_URI = "E:/IDEA/workspace/my-learning/learn-basis/target/classes/" +
            "club/csiqu/learn/basis/jvm/bytecode/Base.class";

    public static void main(String[] args) throws IOException {
        // 读取
        ClassReader classReader = new ClassReader("club.csiqu.learn.basis.jvm.bytecode.Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        // 处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();

        File f = new File(CLASS_URI);
        try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {
            fileOutputStream.write(data);
        }
    }
}