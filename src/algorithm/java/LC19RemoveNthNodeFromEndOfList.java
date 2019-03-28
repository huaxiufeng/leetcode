package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC19RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.fromVals(1);
        System.out.println(listNode.toString());
        LC19RemoveNthNodeFromEndOfList solution = new LC19RemoveNthNodeFromEndOfList();
        listNode = solution.removeNthFromEnd(listNode, 1);
        System.out.println(listNode.toString());
    }
}
