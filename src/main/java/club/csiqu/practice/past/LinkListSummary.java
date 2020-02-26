package club.csiqu.practice.past;

import java.util.HashSet;

/**
 * @author chensiqu
 * @since 2019/3/14 10:08
 */
public class LinkListSummary {

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口节点，否则，输出 {@code null}。
     *
     * @param pHead 链表头节点
     * @return {@code node}如果环的入口存在
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        // 用一个 set 判断是否出现重复节点
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = pHead;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            } else {
                set.add(node);
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 在一个排序的链表中，存在重复的节点，
     * 请删除该链表中重复的节点，重复的节点不保留，返回链表头指针。
     *
     * @param pHead 链表头节点
     * @return 去除重复后的链表头节点
     */
    private ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 递归删除重复链表头
        if (pHead.next != null && pHead.val == pHead.next.val) {
            int temp = pHead.val;
            while (pHead != null && pHead.val == temp) {
                pHead = pHead.next;
            }
            return deleteDuplication(pHead);
        }
        ListNode node = pHead;
        ListNode temp = node.next;
        // 此时头一定不重复 把中间重复节点删除
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                int t = temp.val;
                while (temp != null && temp.val == t) {
                    temp = temp.next;
                }
                node.next = temp;
            } else {
                node = node.next;
                temp = temp.next;
            }
        }
        return pHead;
    }

    public static class ListNode {

        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}