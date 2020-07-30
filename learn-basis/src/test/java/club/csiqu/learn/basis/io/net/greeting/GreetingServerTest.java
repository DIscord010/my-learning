package club.csiqu.learn.basis.io.net.greeting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Siqu Chen 2020/5/12
 * @since 1.0
 */
class GreetingServerTest {

    @BeforeAll
    static void initServer() throws IOException {
        new GreetingServerImpl(8002).service();
    }

    @Test
    void testEchoServerImpl() throws IOException {
        Socket client = new Socket("localhost", 8002);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        String data = "hello from " + client.getLocalAddress();
        out.writeUTF(data);
        Assertions.assertEquals("谢谢连接我：/127.0.0.1 Goodbye！", in.readUTF());
    }
}