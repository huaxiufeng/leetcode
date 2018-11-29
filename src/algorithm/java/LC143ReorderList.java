package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/29.
 */
public class LC143ReorderList {

    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
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
        right = reverse(right);
        merge(left, right);
    }

    private ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode head1Next = head1.next;
        ListNode head2Next = head2.next;
        head1.next = head2;
        head2.next = merge(head1Next, head2Next);
        return head1;
    }

    public static void main(String[] args) {
        LC143ReorderList solution = new LC143ReorderList();
        ListNode listNode = ListNode.fromVals(1,2,3,4,5);
        solution.reorderList(listNode);
        System.out.println(listNode.toString());
    }
}
