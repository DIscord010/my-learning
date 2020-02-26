package club.csiqu.patterns.singleton.damage;

import java.io.*;

/**
 * @author chensiqu 2019/12/5
 * @since 1.0.0
 */
public class SerializeMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singleton = Singleton.getInstance();
        byte[] serializeByte;
        // 序列化为 byte数组
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream)) {
            out.writeObject(singleton);
            serializeByte = byteArrayOutputStream.toByteArray();
        }
        Object serializeSingleton;
        // 通过 byte数组反序列化
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializeByte);
             ObjectInputStream in = new ObjectInputStream(byteArrayInputStream)) {
            serializeSingleton = in.readObject();
        }
        System.out.println(singleton);
        System.out.println(serializeSingleton);
    }
}