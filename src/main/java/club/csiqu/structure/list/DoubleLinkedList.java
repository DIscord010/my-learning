package club.csiqu.structure.list;

/**
 * 双向链表
 *
 * @author chensiqu
 */
class DoubleLinkedList {

    /** 链表的头节点 */
    private Node first;

    /** 链表的尾节点 */
    private Node last;

    /** 链表的节点个数 */
    private int size;

    /**
     * 链表的内部节点
     */
    private static class Node {

        /** 节点的数据 */
        private Object var;

        /** 存储下一个节点的引用 */
        private Node next;

        Node(Object var) {
            this.var = var;
        }

        void display() {
            System.out.print(var + " ");
        }
    }

    /**
     * 构造方法，初始化头尾节点为 {@code null}，size为 0。
     */
    private DoubleLinkedList() {
        this.size = 0;
        first = null;
        last = null;
    }

    /**
     * 判断链表是否为空
     *
     * @return 是否为空链表
     */
    private boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 插入到链表的头端
     *
     * @param element 需要插入的元素
     */
    private void insertFirst(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    /**
     * 插入链表的尾端
     *
     * @param element 需要插入的元素
     */
    private void insertLast(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    /**
     * 删除第一个节点
     *
     * @return 被删除的节点的引用
     * @throws Exception 空链表异常
     */
    private Node deleteFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("链表为空，无法删除！");
        }
        if (first.next == null) {
            last = null;
        }
        Node temp = first;
        first = first.next;
        return temp;
    }

    /**
     * 打印所有节点
     */
    private void display() {
        Node current = first;

        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public static void main(String[] args) throws Exception {
        DoubleLinkedList myLinkedList = new DoubleLinkedList();
        myLinkedList.insertFirst(1);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(3);
        myLinkedList.insertLast("chensiqu");
        myLinkedList.insertLast("chen");
        myLinkedList.insertFirst("test");
        System.out.println(myLinkedList.deleteFirst().var);
        myLinkedList.display();
    }
}