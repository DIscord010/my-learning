package club.csiqu.practice.past;

/**
 * 复杂链表的复制
 */
public class RandomListNodeUtil {

    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode temp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = temp;
            node = node.next.next;
        }
        RandomListNode node1 = pHead;
        while (node1 != null) {
            if (node1.random != null) {
                node1.next.random = node1.random.next;
            }
            node1 = node1.next.next;
        }
        RandomListNode q = pHead.next;
        RandomListNode result = pHead.next;
        RandomListNode p = pHead;
        while (q.next != null) {
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = null;
        return result;
    }

    private static class RandomListNode {

        int label;

        RandomListNode next = null;

        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}