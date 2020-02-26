package club.csiqu.basis.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author chensiqu
 * @since 2019/6/28 14:08
 */
public class DubboSPIMain {

    public static void main(String[] args) {

        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}