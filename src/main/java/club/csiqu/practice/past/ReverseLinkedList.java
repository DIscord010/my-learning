package club.csiqu.practice.past;

public class ReverseLinkedList {

    /**
     * 链表节点内部类
     */
    public static class ListNode {

        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 进行链表倒置
     *
     * @param head 链表头节点
     * @return 倒置后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode next;
        ListNode pre = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            if (next == null) {
                return node;
            }
            node = next;
        }
        return node;
    }

    /**
     * 合并两个已排序链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的已排序链表
     */
    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode head = list1;

        while (list2 != null) {
            while (list1 != null) {
                if (list2.val >= list1.val) {
                    if (list1.next == null || list1.next.val > list2.val) {
                        add(list1, list2.val);
                        break;
                    }
                }
                list1 = list1.next;
            }
            // list1 = head;
            // 已排序数组，只需在上次循环接替即可
            list2 = list2.next;
        }
        return head;
    }

    /**
     * 在指定节点后插入节点
     *
     * @param node 节点插入位置
     * @param var  需插入的节点内容
     */
    public void add(ListNode node, int var) {
        ListNode next = node.next;
        ListNode insert = new ListNode(var);
        node.next = insert;
        insert.next = next;
    }
}