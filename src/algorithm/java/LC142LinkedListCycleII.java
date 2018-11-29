package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/29.
 */
public class LC142LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meet = slow;
                break;
            }
        }
        if (null == meet) {
            return null;
        }
        slow = head;
        while (slow != meet) {
            slow = slow.next;
            meet = meet.next;
        }
        return meet;
    }
}
