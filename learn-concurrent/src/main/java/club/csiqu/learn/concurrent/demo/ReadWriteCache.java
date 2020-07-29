package club.csiqu.learn.concurrent.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁实现通用缓存
 *
 * @author chensiqu
 * @see ReadWriteLock
 * @since 2019/6/21 15:22
 */
public class ReadWriteCache<K, V> {

    /** 缓存数据存放 */
    private final Map<K, V> cache = new HashMap<>();

    /** 读写锁 */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    /** 读锁 */
    private final Lock readLock = lock.readLock();

    /** 写锁 */
    private final Lock writeLock = lock.writeLock();

    /**
     * 私有构造方法
     */
    private ReadWriteCache() {}

    /**
     * 读取缓存数据
     *
     * @param k 键
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public V get(K k) {
        V v;
        readLock.lock();
        try {
            v = cache.get(k);
        } finally {
            readLock.unlock();
        }
        if (v != null) {
            return v;
        }
        writeLock.lock();
        try {
            // 这里需要依照业务逻辑更改
            v = cache.computeIfAbsent(k, k1 -> (V) k1);
        } finally {
            writeLock.unlock();
        }
        return v;
    }

    /**
     * 写缓存数据
     *
     * @param k 键
     * @param v 值
     */
    public void put(K k, V v) {
        writeLock.lock();
        try {
            cache.put(k, v);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 获取单例实例
     *
     * @return {@code instance}
     */
    public static ReadWriteCache<String, String> getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 内部静态类实现懒加载单例，线程安全。
     */
    private static class SingletonHolder {

        private static final ReadWriteCache<String, String> INSTANCE = new ReadWriteCache<>();
    }
}