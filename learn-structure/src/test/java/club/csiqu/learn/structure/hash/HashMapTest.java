package club.csiqu.learn.structure.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Siqu Chen 2020/3/26
 * @since 1.0
 */
class HashMapTest {

    @Test
    void put() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "test");
        assertEquals(1, hashMap.getSize());
    }

    @Test
    void get() {
        HashMap<String, String> hashMap = new HashMap<>();
        assertNull(hashMap.put("test", "test"));
        assertEquals("test", hashMap.get("test"));
    }
}