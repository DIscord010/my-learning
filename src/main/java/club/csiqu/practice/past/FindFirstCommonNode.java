package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/11 15:46
 */
public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            node1 = (node1 == null ? pHead2 : node1.next);
            node2 = (node2 == null ? pHead1 : node2.next);
        }
        return node1;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}