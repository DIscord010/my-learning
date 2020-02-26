package club.csiqu.basis.spi;

import java.util.ServiceLoader;

/**
 * Java SPI示例
 * <p>
 * SPI全称为 Service Provider Interface，
 * 是一种服务发现机制。
 * SPI的本质是将接口实现类的全限定名配置在文件中，
 * 并由服务加载器读取配置文件，加载实现类。
 *
 * @author chensiqu
 * @since 2019/6/28 13:19
 */
public class JavaSPIMain {

    public static void main(String[] args) {

        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}