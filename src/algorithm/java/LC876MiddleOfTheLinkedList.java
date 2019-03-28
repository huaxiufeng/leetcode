package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class LC876MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;
    }
}
