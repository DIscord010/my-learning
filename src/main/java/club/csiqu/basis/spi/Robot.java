package club.csiqu.basis.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author chensiqu
 * @since 2019/6/28 13:17
 */
@SPI
public interface Robot {

    void sayHello();

}