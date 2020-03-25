package club.csiqu.learn.basis.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 将 Java对象进行序列化
 */
public class SerializeMain {

    public static void main(String[] args) {
        Employee e = new Employee("Ali", "Phokka Kuan, Ambehta Peer", 11122333, 101);
        try (FileOutputStream fileOps =
                     new FileOutputStream("src/main/resources/employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOps)) {
            out.writeObject(e);
            System.out.println("Serialized data is saved in /employee.ser");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}