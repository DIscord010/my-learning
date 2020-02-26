package club.csiqu.practice.past;

public class FindKthToTail {

    public static class ListNode {

        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public ListNode findKthToTail(ListNode head, int k) {

        ListNode listNode1 = head;
        ListNode listNode2 = head;
        int i = 0;
        while (listNode1 != null && i < k) {
            listNode1 = listNode1.next;
            i++;
        }
        if (i != k) {
            return null;
        }
        while (listNode1 != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return listNode2;
    }
}