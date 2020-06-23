package club.csiqu.learn.basis.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Siqu Chen 2020/6/23
 * @since 1.0.0
 */
class RobotTest {

    /**
     * Java SPI示例
     * <p>
     * SPI全称为 Service Provider Interface，
     * 是一种服务发现机制。
     * SPI的本质是将接口实现类的全限定名配置在文件中，
     * 并由服务加载器读取配置文件，加载实现类。
     */
    @Test
    void testLoadByJavaSpi() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        Iterator<Robot> iterator = serviceLoader.iterator();
        Robot bumblebee = iterator.next();
        Assertions.assertEquals("Hello, I am Bumblebee.", bumblebee.sayHello());
        Robot optimusPrime = iterator.next();
        Assertions.assertEquals("Hello, I am Optimus Prime.", optimusPrime.sayHello());
    }

    @Test
    void testLoadByDubboSpi() {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        Assertions.assertEquals("Hello, I am Optimus Prime.", optimusPrime.sayHello());
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}