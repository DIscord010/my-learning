package club.csiqu.structure.list;

import org.junit.jupiter.api.Test;

/**
 * @author chensiqu 2019/12/30
 * @since 1.0.0
 */
public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinkedList myLinkedList = new SingleLinkedList();
        myLinkedList.add(123);
        myLinkedList.add(124);
        myLinkedList.add("abc");
        myLinkedList.add(126);
        myLinkedList.add(123);
        myLinkedList.display();
        System.out.println(myLinkedList.delete(123));
        myLinkedList.display();
    }
}