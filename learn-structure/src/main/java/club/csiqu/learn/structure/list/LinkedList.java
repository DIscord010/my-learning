package club.csiqu.learn.structure.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 单向链表
 * 头插法，新插入的节点为头节点
 *
 * @author chensiqu
 */
class LinkedList<E> implements List<E> {

    /** 链表节点的个数 */
    private int size;

    /** 头节点 */
    private Node<E> head;

    /**
     * 构造方法，初始化链表
     */
    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * 链表的内部节点类
     */
    static class Node<E> {

        /** 节点的数据 */
        E value;

        /** 存储下一个节点的引用 */
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = this.head;
        while (node != null) {
            if (node.value.equals(o)) {
                return true;
            }
            node = node.next;
        }
        return false;
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
        Node<E> newNode = new Node<>(e);
        if (this.size != 0) {
            newNode.next = head;
        }
        this.head = newNode;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        // 当前节点的前一个节点
        Node<E> previous = null;
        // 当前节点
        Node<E> current = head;
        while (current != null) {
            if (current.value.equals(o)) {
                // 如果删除的是第一个节点
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                this.size--;
                return true;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return false;
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
    public E get(int index) {
        throw new UnsupportedOperationException();
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
    public E remove(int index) {
        throw new UnsupportedOperationException();
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