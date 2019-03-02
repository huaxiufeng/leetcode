package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/16.
 */
public class LC25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next || k <= 1) {
            return head;
        }
        ListNode groupTail = findTail(head, k);
        if (null == groupTail) {
            return head;
        } else {
            ListNode nextHead = groupTail.next;
            groupTail.next = null;
            ListNode newHead = reverse(head);
            head.next = reverseKGroup(nextHead, k);
            return newHead;
        }
    }

    private ListNode findTail(ListNode head, int k) {
        while (k > 1 && head != null) {
            head = head.next;
            k--;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode resultHead = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = resultHead;
            resultHead = temp;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        LC25ReverseNodesInKGroup solution = new LC25ReverseNodesInKGroup();
        System.out.println(solution.reverseKGroup(ListNode.fromVals(1,2,3,4,5), 2));
        System.out.println(solution.reverseKGroup(ListNode.fromVals(1,2,3,4,5), 3));
    }
}
