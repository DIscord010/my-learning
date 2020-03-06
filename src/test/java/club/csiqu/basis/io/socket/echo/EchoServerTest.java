package club.csiqu.basis.io.socket.echo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Siqu Chen 2020/3/2
 * @since 1.0.0
 */
class EchoServerTest {

    @BeforeEach
    void init() throws IOException {
        new EchoServer().service();
    }

    @Test
    void testEchoServer() throws IOException {
        Socket client = new Socket("localhost", 8000);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        String data = "hello from " + client.getLocalAddress();
        out.writeUTF(data);
        Assertions.assertEquals(data, in.readUTF());
    }
}