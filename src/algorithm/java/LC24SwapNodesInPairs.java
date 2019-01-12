package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode nextList = head.next.next;
        ListNode result = head.next;
        result.next = head;
        result.next.next = swapPairs(nextList);
        return result;
    }

    public static void main(String[] args) {
        LC24SwapNodesInPairs solution = new LC24SwapNodesInPairs();
        System.out.println(solution.swapPairs(ListNode.fromVals(1,2,3,4)).toString());
    }
}
