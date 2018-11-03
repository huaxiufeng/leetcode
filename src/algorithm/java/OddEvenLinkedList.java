package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (odd.next !=null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();
        ListNode head = buildListNode();
        ListNode result = solution.oddEvenList(head);
        System.out.println(result.toString());
    }

    private static ListNode buildListNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }
}
