package club.csiqu.framework.dubbo.demo.api;

/**
 * @author chensiqu 2020/1/8
 * @since 1.0.0
 */
public interface HelloService {

    /**
     * sayHello
     *
     * @param name name
     * @return {@link String}
     */
    String sayHello(String name);
}