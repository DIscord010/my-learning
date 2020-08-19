package club.csiqu.learn.basis.net;

/**
 * @author Siqu Chen 2020/5/7
 * @since 1.0
 */
public abstract class AbstractStopServer implements Server {

    protected volatile boolean serviceFlag = true;

    @Override
    public void stopService() {
        this.serviceFlag = false;
    }
}