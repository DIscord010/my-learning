package club.csiqu.framework.dubbo.my.rpc.consumer.proxy;

import club.csiqu.framework.dubbo.my.rpc.provider.model.RpcTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:50
 */
public class RpcProxy {

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new JDKDynamicProxy(clazz.getName()));
    }

    private static class JDKDynamicProxy implements InvocationHandler {

        private static final Logger LOGGER = LoggerFactory.getLogger(JDKDynamicProxy.class);

        private String clazzName;

        JDKDynamicProxy(String clazzName) {
            this.clazzName = clazzName;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws IOException {
            // RPC本质上即为序列化加上网络传输
            try (Socket client = new Socket("localhost", 9999);
                 OutputStream out = client.getOutputStream();
                 ObjectOutputStream objectOut = new ObjectOutputStream(out);
                 InputStream in = client.getInputStream();
                 ObjectInputStream objectIn = new ObjectInputStream(in)) {
                RpcTransfer rpcTransfer = new RpcTransfer();
                rpcTransfer.setClazzName(clazzName);
                rpcTransfer.setClazzs(method.getParameterTypes());
                rpcTransfer.setMethodName(method.getName());
                rpcTransfer.setArgs(args);
                objectOut.writeObject(rpcTransfer);
                return objectIn.readObject();
            } catch (ClassNotFoundException e) {
                LOGGER.warn("获取RPC返回对象出现异常：{}", e.getMessage());
            }
            return null;
        }
    }
}