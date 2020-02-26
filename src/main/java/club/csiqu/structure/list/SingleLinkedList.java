package club.csiqu.structure.list;

/**
 * 单向链表
 * 头插法，新插入的节点为头节点
 *
 * @author chensiqu
 */
class SingleLinkedList {

    /** 链表节点的个数 */
    private int size;

    /** 头节点 */
    private Node head;

    /**
     * 链表的内部节点类
     */
    private static class Node {

        /** 节点的数据 */
        Object var;

        /** 存储下一个节点的引用 */
        Node next;

        Node(Object var) {
            this.var = var;
        }
    }

    /**
     * 构造方法，初始化链表
     */
    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * 添加链表元素
     *
     * @param element 节点数据
     */
    public void add(Object element) {
        Node newNode = new Node(element);
        if (this.size != 0) {
            newNode.next = head;
        }
        this.head = newNode;
        this.size++;
    }

    /**
     * 链表头删除节点
     *
     * @return 删除的节点数据
     */
    public Object deleteHead() {
        Object object = this.head.var;
        head = head.next;
        this.size--;
        return object;
    }

    /**
     * 打印所有的节点信息
     */
    public void display() {
        Node node = this.head;
        if (this.size == 0) {
            System.out.print("[]");
        } else {
            System.out.print("[");
            while (node != null) {
                System.out.print(node.var + "->");
                node = node.next;
            }
            System.out.print("]");
        }
        System.out.println();
    }

    /**
     * 判断链表是否为空
     *
     * @return 是否为空列表
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 查找列表内指定节点
     *
     * @param object 查找目标
     * @return 节点, 没有则返回空
     */
    public Node find(Object object) {
        Node node = this.head;
        while (node != null) {
            if (node.var.equals(object)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 删除制定内容的节点，删除的为匹配到的第一个相同元素。
     *
     * @param object 需要删除的节点内容
     * @return 是否删除成功
     */
    public boolean delete(Object object) {
        if (size == 0) {
            return false;
        }
        // 当前节点
        Node current = head;
        // 当前节点的前一个节点
        Node previous = null;
        while (current != null) {
            if (current.var.equals(object)) {
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
}