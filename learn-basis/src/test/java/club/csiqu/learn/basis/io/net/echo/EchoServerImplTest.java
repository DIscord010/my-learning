package club.csiqu.learn.basis.io.net.echo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Siqu Chen 2020/5/7
 * @since 1.0.0
 */
class EchoServerImplTest {

    @BeforeAll
    static void initServer() throws IOException {
        new EchoServerImpl().service();
    }

    @Test
    void testEchoServerImpl() throws IOException {
        Socket client = new Socket("localhost", 8000);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        String data = "hello from " + client.getLocalAddress();
        out.writeUTF(data);
        Assertions.assertEquals(data, in.readUTF());
    }
}