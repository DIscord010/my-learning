package club.csiqu.learn.structure.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chensiqu
 * @since 2019/4/3 11:29
 */
class HashMap<K, V> {

    /** 默认空间大小为 16 */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /** 默认扩容因子为 0.75 */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /** 最大空间 */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /** {@code table}内 {@link Entry<>}的数量 */
    private int size;

    /** 空间大小，即 {@code table}的长度 */
    private int capacity;

    /** 扩容因子 */
    private final float loadFactor;

    /** hashTable */
    private Entry<K, V>[] table;

    /**
     * 构造器
     */
    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 构造器
     *
     * @param capacity   初始空间大小
     * @param loadFactor 扩容因子
     */
    @SuppressWarnings("unchecked")
    private HashMap(int capacity, float loadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("illegal argument：" + capacity);
        }
        this.capacity = tableSizeFor(capacity);
        this.loadFactor = loadFactor;
        table = new Entry[this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    /**
     * 内部链表节点
     *
     * @param <K> 键
     * @param <V> 值
     */
    static class Entry<K, V> implements Map.Entry<K, V> {

        final int hash;

        final K key;

        V value;

        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    /**
     * 放入键值对
     *
     * @return 如果存在相同的 key，则返回旧键值对的 {@code value}。
     */
    public V put(K k, V v) {
        V oldValue;
        if (size >= capacity * loadFactor) {
            // 扩容为原空间的两倍
            resize(capacity << 1);
        }
        int hash = hash(k);
        int index = hash & (capacity - 1);
        if (table[index] == null) {
            table[index] = new Entry<>(hash, k, v, null);
        } else {
            // 哈希冲突
            // 遍历单链表
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (entry != null) {
                // 存在相同 key则替换 value，返回旧的 value
                if (k == entry.getKey() || k.equals(entry.getKey())) {
                    oldValue = entry.value;
                    entry.value = v;
                    return oldValue;
                }
                entry = entry.next;
            }
            // 不存在则将新 entry放入单链表的头
            table[index] = new Entry<>(hash, k, v, e);
        }
        size++;
        return null;
    }

    /**
     * 获取 {@code key}对应的值
     *
     * @param key 键
     * @return 存在的话，返回对应的值
     */
    public V get(K key) {
        int index = hash(key) & (capacity - 1);
        // 当 capacity为 2的幂数时，capacity % length = capacity & (length - 1)。
        if (table[index] == null) {
            return null;
        } else {
            Entry<K, V> entry = table[index];
            do {
                if (key == entry.getKey() || key.equals(entry.getKey())) {
                    return entry.value;
                }
                entry = entry.next;
            } while (entry != null);
        }
        return null;
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 新空间
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Entry<K, V>[] newTable = new Entry[newCapacity];
        capacity = newCapacity;
        size = 0;
        // 重新装填
        rehash(newTable);
    }

    /**
     * 重新散列
     *
     * @param newTable 新数组
     */
    public void rehash(Entry<K, V>[] newTable) {
        List<Entry<K, V>> list = new ArrayList<>();
        // 将旧元素放入集合中
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    list.add(entry);
                    entry = entry.next;
                } while (entry != null);
            }
        }
        if (newTable.length > 0) {
            table = newTable;
        }
        // 重新 put进新 table
        for (Entry<K, V> entry : list) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 哈希函数
     *
     * @param k 键
     * @return {@code h},键的哈希值。
     */
    private int hash(K k) {
        int h = k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * 保证 {@code table}长度为 2的幂数
     *
     * @param cap 构造器定义的空间大小
     * @return 最接近 {@code cap}的 2的幂数
     */
    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        if (n < 0) {
            return 1;
        } else {
            return (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }
    }
}