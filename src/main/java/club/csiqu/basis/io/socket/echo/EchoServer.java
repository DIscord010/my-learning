package club.csiqu.basis.io.socket.echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务端（多线程，每次接收连接则新建一个线程处理）
 * <p>
 * 每次接收到连接就新建一个线程进行处理。
 * 收到数据后将该数据回传。（新建一个线程大约需要 1M的内存，且线程创建和销毁需要大量开销）
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/4 13:55
 */
public class EchoServer {

    private ServerSocket serverSocket;

    private EchoServer() throws IOException {

        int port = 8000;
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void service() {
        while (true) {

            try {
                Socket socket = serverSocket.accept();
                Thread workThread = new Thread(new Handler(socket));
                workThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }

    static class Handler implements Runnable {

        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                System.out.println("远程主机地址： " + socket.getRemoteSocketAddress());
                String s = in.readUTF();
                System.out.println(s);
                out.writeUTF(s);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}