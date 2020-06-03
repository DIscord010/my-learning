package club.csiqu.learn.basis.exception.closeable;

/**
 * @author Siqu Chen 2020/6/3
 * @since 1.0.0
 */
public class AutoCloseableImpl implements AutoCloseable {

    public void sendData() throws IllegalAccessException {
        throw new IllegalAccessException("Method sendData() exception.");
    }

    @Override
    public void close() throws Exception {
        throw new IllegalAccessException("Method close() exception.");
    }
}