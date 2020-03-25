package club.csiqu.learn.basis.serialize;

import java.io.*;

/**
 * 将序列化的文件反序列化
 */
public class DeserializeMain {

    public static void main(String[] args) {
        Employee e = null;
        try (FileInputStream fileIps =
                     new FileInputStream("src/main/resources/employee.ser");
             ObjectInputStream in = new ObjectInputStream(fileIps)) {
            e = (Employee)in.readObject();
            System.out.println("Deserialized success");
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        if (e != null) {
            e.Check();
        }
    }
}