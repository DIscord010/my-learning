package club.csiqu.learn.basis.jvm.bytecode.asm;

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
public class Generator {

    public static void main(String[] args) throws IOException {

        // 读取
        ClassReader classReader = new ClassReader("club.csiqu.basis.jvm.bytecode.asm.Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        // 处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();

        File f = new File("E:/IDEA/workspace/my-learning/target/classes/club/csiqu/basis/jvm/bytecode/asm/Base.class");
        try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {
            fileOutputStream.write(data);
        }
        System.out.println("generator cc success!!!");
    }
}