package club.csiqu.learn.concurrent.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/7/29
 * @since 1.0
 */
class ReadWriteCacheTest {

    @Test
    void testWriteCache() {
        ReadWriteCache<String, String> cache = ReadWriteCache.getInstance();
        cache.put("1", "123456");
        Assertions.assertEquals("123456", cache.get("1"));
        Assertions.assertEquals("2", cache.get("2"));
    }
}