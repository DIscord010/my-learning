package club.csiqu.learn.basis.jvm.loading;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/5/27
 * @since 1.0
 */
class MyClassLoaderTest {

    @Test
    public void testLoadClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Object obj1 = MyClassLoader.class.newInstance();
        // 获取自定义类加载器加载的类的实例对象
        Object obj2 = myClassLoader.loadClass("club.csiqu.learn.basis.jvm.loading.MyClassLoader").newInstance();
        Assertions.assertEquals(obj1.getClass().toString(), obj2.getClass().toString());
        Assertions.assertFalse(obj2 instanceof MyClassLoader);
    }
}