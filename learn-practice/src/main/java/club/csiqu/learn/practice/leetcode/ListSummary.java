package club.csiqu.learn.practice.leetcode;

/**
 * @author Siqu Chen 2020/6/1
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class ListSummary {

    /**
     * LeetCode 2.两数相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后返回的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode listNode = root;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp;
            if (l1 == null) {
                temp = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                temp = l1.val + carry;
                l1 = l1.next;
            } else {
                temp = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = temp / 10;
            temp = temp % 10;
            listNode.next = new ListNode(temp);
            listNode = listNode.next;
        }
        if (carry == 1) {
            listNode.next = new ListNode(1);
        }
        return root.next;
    }
}