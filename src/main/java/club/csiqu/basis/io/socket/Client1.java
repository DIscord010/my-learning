package club.csiqu.basis.io.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 14:28
 */
public class Client1 {

    public static void main(String[] args) {
        System.out.println("连接到主机： " + "localhost" + " 端口：" + 8000);
        try (Socket client = new Socket("localhost", 8000);
             DataOutputStream out = new DataOutputStream(client.getOutputStream());
             DataInputStream in = new DataInputStream(client.getInputStream())) {

            System.out.println("远程主机地址： " + client.getRemoteSocketAddress());
            out.writeUTF("hello from " + client.getLocalAddress());
            System.out.println("服务器响应： " + in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}