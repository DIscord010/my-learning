package club.csiqu.framework.rpc.my.provider;

import club.csiqu.framework.rpc.my.provider.model.RpcTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单实现 RPC。
 * <p>
 * 使用 JDK代理、Java序列化以及 BIO。
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/10/1 14:44
 */
public class RpcServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServer.class);

    /** 服务列表 */
    private static final ConcurrentHashMap<String, String> SERVER_LIST = new ConcurrentHashMap<>(16);

    @SuppressWarnings("InfiniteLoopStatement")
    private void start() throws IOException {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(20000);
        } catch (IOException e) {
            LOGGER.error("RPC服务开启失败：{}, 可能为端口被占用", e.getMessage());
            return;
        }
        while (true) {
            // 阻塞等待直到有客户端连接接入
            Socket socket = serverSocket.accept();
            try (InputStream in = socket.getInputStream();
                 ObjectInputStream objectIn = new ObjectInputStream(in);
                 OutputStream out = socket.getOutputStream();
                 ObjectOutputStream objectOut = new ObjectOutputStream(out)) {
                RpcTransfer rpcTransfer = (RpcTransfer) objectIn.readObject();
                String className = rpcTransfer.getClazzName();
                Class<?> clazz = Class.forName(SERVER_LIST.get(className));
                Object o = clazz.newInstance();
                Method method = clazz.getMethod(rpcTransfer.getMethodName(), rpcTransfer.getClazzs());
                // 写入返回对象
                Object result = method.invoke(o, rpcTransfer.getArgs());
                objectOut.writeObject(result);
            } catch (ClassNotFoundException e) {
                LOGGER.warn("读取RPC传输对象出现异常：{}", e.getMessage());
            } catch (IllegalAccessException e) {
                LOGGER.warn("非法访问：{}", e.getMessage());
            } catch (InstantiationException e) {
                LOGGER.warn("反射实例化异常：{}", e.getMessage());
            } catch (InvocationTargetException e) {
                LOGGER.warn("反射调用目标方法异常：{}", e.getMessage());
            } catch (NoSuchMethodException e) {
                LOGGER.warn("未找到目标方法：{}", e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 注册服务
        SERVER_LIST.put("org.chensiqu.framework.rpc.my.api.service.HelloService",
                "org.chensiqu.framework.rpc.my.provider.service.impl.HelloServiceImpl");
        new RpcServer().start();
    }
}