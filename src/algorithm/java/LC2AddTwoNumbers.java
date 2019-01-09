package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 19/1/9.
 */
public class LC2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultTail = null;
        int advance = 0;
        while (l1 != null || l2 != null) {
            int digitSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + advance;
            if (digitSum >= 10) {
                advance = 1;
                digitSum = digitSum % 10;
            } else {
                advance = 0;
            }
            if (null == result) {
                result = new ListNode(digitSum);
                resultTail = result;
            } else {
                resultTail.next = new ListNode(digitSum);
                resultTail = resultTail.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (advance > 0) {
            resultTail.next = new ListNode(advance);
        }
        return result;
    }

    public static void main(String[] args) {
        LC2AddTwoNumbers solution = new LC2AddTwoNumbers();
        System.out.println(solution.addTwoNumbers(ListNode.fromVals(2, 4, 3), ListNode.fromVals(5, 6, 4, 1)));
    }
}
