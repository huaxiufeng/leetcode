package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/29.
 */
public class LC148SortList {

    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (null == head1) {
            return head2;
        } else if (null == head2) {
            return head1;
        }
        ListNode smaller;
        if (head1.val < head2.val) {
            smaller = head1;
            head1 = head1.next;
        } else {
            smaller = head2;
            head2 = head2.next;
        }
        smaller.next = merge(head1, head2);
        return smaller;
    }

    public static void main(String[] args) {
        LC148SortList solution = new LC148SortList();
        System.out.println(solution.sortList(ListNode.fromVals(-1, 5, 3, 4, 0)));
        System.out.println(solution.sortList(ListNode.fromVals(4, 2, 1, 3)));
    }
}
