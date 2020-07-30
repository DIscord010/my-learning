package club.csiqu.learn.pattern.singleton.damage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Siqu Chen 2020/5/18
 * @since 1.0
 */
class SerializeDamageTest {

    @Test
    public void testSerializeDamageSingleton() throws IOException, ClassNotFoundException {
        SerializableSingleton singleton0 = SerializableSingleton.getInstance();
        Object singleton1 = SerializeDamage.deserialization(SerializeDamage.serialize(singleton0));
        // 可以发现两个实例对象并不相同，序列化对单例造成了破坏
        Assertions.assertNotEquals(singleton0, singleton1);
    }

    @Test
    public void testSerializeSafeSingleton() throws IOException, ClassNotFoundException {
        SerializeSafeSingleton singleton0 = SerializeSafeSingleton.getInstance();
        Object singleton1 = SerializeDamage.deserialization(SerializeDamage.serialize(singleton0));
        // 获取的实例对象相同
        Assertions.assertEquals(singleton0, singleton1);
    }
}