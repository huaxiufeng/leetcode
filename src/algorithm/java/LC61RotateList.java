package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by amyhuiye on 2018/11/8.
 */
public class LC61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head, second = head;
        int len = 0;
        while (k > 0) {
            first = first.next;
            len++;
            k--;
            if (first == null) {
                k = k % len;
                first = head;
            }
        }
        if (first == second) {
            return head;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        ListNode result = second.next;
        second.next = null;
        first.next = head;
        return result;
    }

    public static void main(String[] args) {
        LC61RotateList solution = new LC61RotateList();
        System.out.println(solution.rotateRight(ListNode.fromVals(0, 1, 2, 3, 4, 5), 4));
        System.out.println(solution.rotateRight(ListNode.fromVals(0, 1, 2), 4));
    }
}
