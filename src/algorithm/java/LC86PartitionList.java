package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by amyhuiye on 2018/11/9.
 */
public class LC86PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode less = null, lessTail = null;
        ListNode rest = null, restTail = null;
        while (head != null) {
            if (head.val < x) {
                if (less == null) {
                    less = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
            } else {
                if (rest == null) {
                    rest = head;
                    restTail = head;
                } else {
                    restTail.next = head;
                    restTail = restTail.next;
                }
            }
            head = head.next;
        }
        if (lessTail != null) {
            lessTail.next = rest;
        }
        if (restTail != null) {
            restTail.next = null;
        }
        if (less != null) {
            return less;
        }
        return rest;
    }

    public static void main(String[] args) {
        LC86PartitionList solution = new LC86PartitionList();
        System.out.println(solution.partition(ListNode.fromVals(1,4,3,2,5,2), 2));
    }
}
