package club.csiqu.learn.basis.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * JMX使用示例
 * <p>
 * 通过 JConsole可以进行动态的修改 Mbean的属性值（提供 set方法）
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 14:23
 */
public class JmxMain {

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException,
            NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        MyCustomMBean myCustom = new MyCustom();
        mBeanServer.registerMBean(myCustom, new ObjectName("myBean:name=MyJMXTestUtil"));
        while (true) {
            Thread.sleep(1000);
            System.out.println(myCustom.getInfo());
        }
    }
}