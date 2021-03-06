package club.csiqu.learn.framework.rpc.tiny.server;

import club.csiqu.learn.framework.rpc.tiny.model.RpcTransfer;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    private static final ConcurrentMap<String, String> SERVER_LIST = new ConcurrentHashMap<>(16);

    private final Executor executor = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("rpc-server-pool-%d").build());

    public void service() {
        executor.execute(() -> {
            ServerSocket serverSocket;
            try {
                serverSocket = new ServerSocket(9999);
            } catch (IOException e) {
                LOGGER.error("服务端启动失败：{}, 可能为端口被占用", e.getMessage());
                return;
            }
            while (true) {
                Socket socket = null;
                try {
                    // 阻塞等待直到有客户端连接接入
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    LOGGER.error("获取客户端接入连接出现IO异常：{}", e.getMessage());
                }
                if (socket == null) {
                    continue;
                }
                receiveDataHandler(socket);
            }
        });
    }

    public void addServer(String serviceName, String serviceUrl) {
        SERVER_LIST.putIfAbsent(serviceName, serviceUrl);
    }

    private void receiveDataHandler(Socket socket) {
        try (InputStream in = socket.getInputStream();
             ObjectInputStream objectIn = new ObjectInputStream(in);
             OutputStream out = socket.getOutputStream();
             ObjectOutputStream objectOut = new ObjectOutputStream(out)) {
            RpcTransfer rpcTransfer = (RpcTransfer)objectIn.readObject();
            String className = rpcTransfer.getClazzName();
            Class<?> clazz = Class.forName(SERVER_LIST.get(className));
            Object o = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getMethod(rpcTransfer.getMethodName(), rpcTransfer.getClazzs());
            // 写入返回对象
            Object result = method.invoke(o, rpcTransfer.getArgs());
            objectOut.writeObject(result);
        } catch (ClassNotFoundException e) {
            LOGGER.warn("RPC传输对象反序列化错误，对应类型不存在：{}", e.getMessage());
        } catch (IllegalAccessException e) {
            LOGGER.warn("调用方法非法访问：{}", e.getMessage());
        } catch (InstantiationException e) {
            LOGGER.warn("反射实例化异常：{}", e.getMessage());
        } catch (InvocationTargetException e) {
            LOGGER.warn("反射调用目标方法异常：{}", e.getMessage());
        } catch (NoSuchMethodException e) {
            LOGGER.warn("未找到目标方法：{}", e.getMessage());
        } catch (IOException e) {
            LOGGER.warn("IO传输异常，可能为客户端突然关闭连接：{}", e.getMessage());
        }
    }
}