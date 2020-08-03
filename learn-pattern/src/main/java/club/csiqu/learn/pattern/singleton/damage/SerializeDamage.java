package club.csiqu.learn.pattern.singleton.damage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0
 */
public class SerializeDamage {

    private SerializeDamage() {}

    public static byte[] serialize(Serializable singleton) throws IOException {
        byte[] serializeByte;
        // 序列化为 byte数组
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream)) {
            out.writeObject(singleton);
            serializeByte = byteArrayOutputStream.toByteArray();
            return serializeByte;
        }
    }

    public static Object deserialization(byte[] singleton) throws IOException, ClassNotFoundException {
        Object serializeSingleton;
        // 通过 byte数组反序列化
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(singleton);
             ObjectInputStream in = new ObjectInputStream(byteArrayInputStream)) {
            serializeSingleton = in.readObject();
            return serializeSingleton;
        }
    }
}