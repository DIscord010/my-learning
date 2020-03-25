package club.csiqu.learn.basis.jmx;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/12 14:21
 */
public class MyCustom implements MyCustomMBean {

    private String serverName = "custom";

    private int port = 8000;

    @Override
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String getServerName() {
        return serverName;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getInfo() {
        return "hello, " + serverName;
    }
}