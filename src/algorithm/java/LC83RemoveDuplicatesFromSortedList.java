package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/13.
 */
public class LC83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode result = head;
        ListNode resultTail = head;
        while (head != null) {
            if (head.val != resultTail.val) {
                resultTail.next = head;
                resultTail = resultTail.next;
            }
            head = head.next;
        }
        resultTail.next = null;
        return result;
    }

    public static void main(String[] args) {
        LC83RemoveDuplicatesFromSortedList solution = new LC83RemoveDuplicatesFromSortedList();
        System.out.println(solution.deleteDuplicates(ListNode.fromVals(1,1,2)));
        System.out.println(solution.deleteDuplicates(ListNode.fromVals(1,1,2,3,3)));
    }
}
