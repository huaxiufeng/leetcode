package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/13.
 */
public class LC82RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        int headVal = head.val;
        ListNode nextHead = head;
        while (nextHead != null && nextHead.val == headVal) {
            nextHead = nextHead.next;
        }
        if (nextHead == head.next) {
            head.next = deleteDuplicates(nextHead);
            return head;
        } else {
            return deleteDuplicates(nextHead);
        }
    }

    public static void main(String[] args) {
        LC82RemoveDuplicatesFromSortedListII solution = new LC82RemoveDuplicatesFromSortedListII();
        System.out.println(solution.deleteDuplicates(ListNode.fromVals(1,1)));
        System.out.println(solution.deleteDuplicates(ListNode.fromVals(1,1,1,2,3)));
        System.out.println(solution.deleteDuplicates(ListNode.fromVals(1,2,3,3,4,4,5)));
        System.out.println(solution.deleteDuplicates(ListNode.fromVals(1,1,1,2,2,2)));
    }
}
