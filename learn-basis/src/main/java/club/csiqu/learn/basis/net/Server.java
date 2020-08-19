package club.csiqu.learn.basis.net;

/**
 * 服务端接口
 *
 * @author Siqu Chen 2020/5/7
 * @since 1.0
 */
public interface Server {

    /**
     * 启动服务端，并提供服务
     */
    void service();

    /**
     * 停止服务
     */
    void stopService();
}