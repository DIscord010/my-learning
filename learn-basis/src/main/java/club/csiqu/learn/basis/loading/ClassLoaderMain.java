package club.csiqu.learn.basis.loading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器验证
 *
 * @author chensiqu
 * @since 2019/5/5 22:48
 */
public class ClassLoaderMain {

    public static void main(String[] args) throws Exception {

        // 自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                // 文件名拼接
                String fileName = name.substring(name.lastIndexOf(".") + 1)
                        + ".class";
                try (
                        // 获取 .class文件流
                        InputStream is = getClass().getResourceAsStream(fileName)) {

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
        };

        // 获取自定义类加载器加载的类的实例对象
        Object obj1 =
                myLoader.loadClass("club.csiqu.basis.loading.ClassLoaderMain").newInstance();
        Object obj2 = new ClassLoaderMain();
        System.out.println(obj1.getClass());
        System.out.println(obj2.getClass());
        System.out.println(obj1 instanceof ClassLoaderMain);
    }
}