package club.csiqu.learn.structure.list;

/**
 * 简单实现动态数组
 *
 * @param <E> 数组内元素类型
 * @author chensiqu
 * @since 2019/3/29 18:02
 */
public class ArrayList<E> {

    /** 元素数组 */
    private Object[] elementData;

    /** 数组元素数量 */
    private int size;

    /** 默认数组空间大小 */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 无参构造函数，默认数组空间大小为 10。
     */
    public ArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 根据给定的空间大小申请数组空间
     *
     * @param capacity 数组空间大小
     */
    public ArrayList(int capacity) {
        this.elementData = new Object[capacity];
    }

    /**
     * 添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        if (size >= elementData.length) {
            grow();
        }
        elementData[size++] = e;
    }

    /**
     * 数组扩容
     */
    private void grow() {
        // 建立一个空间大小为之前空间两倍的新数组
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity << 1;
        Object[] objects = new Object[newCapacity];

        // 将旧数组元素复制进新数组
        System.arraycopy(elementData, 0, objects, 0, elementData.length);
        elementData = objects;
    }

    /**
     * 删除某一位置的元素
     *
     * @param index 下标
     */
    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--;
    }

    /**
     * 获取某一下标的元素
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        return (E) elementData[index];
    }

    public int size() {
        return this.size;
    }
}