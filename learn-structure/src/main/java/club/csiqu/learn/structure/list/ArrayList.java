package club.csiqu.learn.structure.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 简单实现动态数组
 *
 * @param <E> 数组内元素类型
 * @author chensiqu
 * @since 2019/3/29 18:02
 */
public class ArrayList<E> implements List<E> {

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

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        if (size >= elementData.length) {
            grow();
        }
        elementData[size++] = e;
        return true;
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

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        Object result = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--;
        return (E) result;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}