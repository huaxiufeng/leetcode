package algorithm.java;

import java.util.Stack;

/**
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * Created by huaxiufeng on 17/3/2.
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
    // stupid
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode cursor = head;
        while (cursor != null) {
            nodeStack.push(cursor);
            cursor = cursor.next;
        }
        cursor = head;
        while (cursor != null) {
            ListNode current = cursor;
            cursor = cursor.next;
            ListNode reverse = nodeStack.pop();
            if (reverse == current) {
                reverse.next = null;
                break;
            } else if (current.next == reverse) {
                reverse.next = null;
                break;
            } else {
                current.next = reverse;
                reverse.next = cursor;
            }
        }
    }
    */

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode head1 = head, head2 = p1.next;
        p1.next = null;
        ListNode rHead2 = null, cursor2 = head2;
        while (cursor2 != null) {
            ListNode current2 = cursor2;
            cursor2 = cursor2.next;
            current2.next = rHead2;
            rHead2 = current2;
        }
        head2 = rHead2;

        p1 = head1;
        p2 = head2;
        while (p2 != null) {
            ListNode current1 = p1, current2 = p2;
            p1 = p1.next;
            p2 = p2.next;
            current1.next = current2;
            current2.next = p1;
        }
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode head = p;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(6);
        p = p.next;
        p.next = null;
        
        new ReorderList().reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
