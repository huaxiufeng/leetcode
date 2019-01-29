package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 17/3/2.
 */
public class LC206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rHead = null;
        ListNode cursor = head;
        while (cursor != null) {
            ListNode cur = cursor;
            cursor = cursor.next;
            cur.next = rHead;
            rHead = cur;
        }
        return rHead;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        head = head.next;
        node.next = null;
        ListNode rhead = reverseListRecursive(head);
        ListNode rtail = rhead;
        while (rtail.next != null) {
            rtail = rtail.next;
        }
        rtail.next = node;
        return rhead;
    }

    public ListNode reverseListRecursiveOptimize(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] pair = doReverseListRecursiveOptimize(head);
        return pair[0];
    }

    private ListNode[] doReverseListRecursiveOptimize(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode node = head;
        head = head.next;
        node.next = null;
        ListNode[] pair = doReverseListRecursiveOptimize(head);
        pair[1].next = node;
        pair[1] = node;
        return pair;
    }

    public static void main(String[] args) {
        LC206ReverseLinkedList solution = new LC206ReverseLinkedList();
        System.out.println(solution.reverseList(ListNode.fromVals(1, 2, 3, 4, 5, 6)));
    }
}
