package club.csiqu.practice.past;

import java.util.ArrayList;

public class PrintLinkList {

    public ArrayList<Integer> printList(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return new ArrayList<>();
        }
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            list1.add(list.get(i));
        }
        return list1;
    }

    public static class ListNode {

        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}