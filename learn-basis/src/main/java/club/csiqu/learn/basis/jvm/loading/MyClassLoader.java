package club.csiqu.learn.basis.jvm.loading;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Siqu Chen 2020/5/27
 * @since 1.0.0
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        // 文件名拼接
        String fileName = name.substring(name.lastIndexOf('.') + 1)
                + ".class";
        // 获取 .class文件流
        try (InputStream is = getClass().getResourceAsStream(fileName)) {
            if (is == null) {
                return super.loadClass(name);
            }
            byte[] bytes = new byte[is.available()];

            // 将文件流转为 byte[]
            int len = is.read(bytes);
            // 返回类对象
            return defineClass(name, bytes, 0, len);

        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }
}