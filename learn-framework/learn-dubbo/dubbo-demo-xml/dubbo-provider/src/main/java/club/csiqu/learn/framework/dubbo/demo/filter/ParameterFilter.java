package club.csiqu.learn.framework.dubbo.demo.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/7/14
 * @since 1.0.0
 */
@Activate(group = "demo")
public class ParameterFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {
        LOGGER.info("param:{}", RpcContext.getContext().getAttachment("param"));
        return invoker.invoke(invocation);
    }
}