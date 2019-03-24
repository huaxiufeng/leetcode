package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 19/3/24.
 */
public class LC203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode resultHead = null;
        ListNode resultTail = null;
        while (head != null) {
            if (head.val != val) {
                if (null == resultHead) {
                    resultHead = head;
                    resultTail = head;
                } else {
                    resultTail.next = head;
                    resultTail = resultTail.next;
                }
            }
            head = head.next;
        }
        if (resultTail != null) {
            resultTail.next = null;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        LC203RemoveLinkedListElements solution = new LC203RemoveLinkedListElements();
        System.out.println(solution.removeElements(ListNode.fromVals(1,2,6,3,4,5,6), 6)); // 1->2->3->4->5
    }
}
