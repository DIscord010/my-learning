package club.csiqu.learn.framework.mybatis.demo.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author Siqu Chen 2020/10/30
 * @since 1.0.0
 */
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class})})
public class PaginationInterceptor implements Interceptor {

    public static final Logger LOGGER = LoggerFactory.getLogger(PaginationInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        LOGGER.info("PaginationInterceptor execute.");
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        // ignore
    }
}