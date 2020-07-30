package club.csiqu.learn.framework.dubbo.demo.generic;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/7/16
 * @since 1.0
 */
public class DubboGenericInvokeApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboGenericInvokeApplication.class);

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("application");
        ApplicationModel.getConfigManager().setApplication(applicationConfig);

        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface("club.csiqu.learn.framework.dubbo.service.HelloService");
        reference.setGroup("demo");
        reference.setUrl("dubbo://127.0.0.1:20880");
        reference.setGeneric("true");

        GenericService genericService = reference.get();
        Object result = genericService.$invoke("sayHello",
                new String[]{String.class.getName()},
                new Object[]{"hello"});
        LOGGER.info("Generic invoke result is {}", result);
    }
}