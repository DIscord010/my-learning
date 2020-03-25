package club.csiqu.learn.basis.jmx;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 14:18
 */
public interface MyCustomMBean {

    void setServerName(String serverName);

    String getServerName();

    void setPort(int port);

    int getPort();

    String getInfo();
}