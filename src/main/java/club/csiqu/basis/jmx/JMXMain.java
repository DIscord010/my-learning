package club.csiqu.basis.jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * JMX使用示例
 * <p>
 * 通过 jcosole可以进行动态的修改 Mbean的属性值（提供 set方法）
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 14:23
 */
public class JMXMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(JMXMain.class);

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        MyCustomMBean myCustom = new MyCustom();
        mBeanServer.registerMBean(myCustom, new ObjectName("myBean:name=MyJMXTestUtil"));
        while (true) {
            Thread.sleep(1000);
            LOGGER.info(myCustom.getInfo());
        }
    }
}