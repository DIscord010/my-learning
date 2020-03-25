package club.csiqu.learn.basis.io.socket;


import club.csiqu.learn.basis.io.socket.echo.EchoServer;
import club.csiqu.learn.basis.io.socket.greeting.GreetingServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 在此例子下，客户端连接上服务端后，发送一次数据即关闭连接。
 * <p>
 * {@link GreetingServer} 在使用此服务端（单线程）的情况下，其余客户端会被阻塞
 * {@link EchoServer} 在使用此服务端（每连接新建线程）的情况下，其余客户端不会被阻塞
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 14:28
 */
public class Client0 {

    public static void main(String[] args) {

        System.out.println("连接到主机： " + "localhost" + " 端口：" + 8000);
        try (Socket client = new Socket("localhost", 8000);
             DataOutputStream out = new DataOutputStream(client.getOutputStream());
             DataInputStream in = new DataInputStream(client.getInputStream())) {

            System.out.println("远程主机地址： " + client.getRemoteSocketAddress());
            // 线程暂停运行，在多客户端的情况下观察其他客户端是否在阻塞等待
            Thread.sleep(10000);
            out.writeUTF("hello from " + client.getLocalAddress());
            System.out.println("服务器响应： " + in.readUTF());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}