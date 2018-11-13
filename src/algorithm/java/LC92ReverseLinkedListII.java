package algorithm.java;

import algorithm.java.data.ListNode;

import java.util.Stack;

/**
 * Created by amyhuiye on 2018/11/14.
 */
public class LC92ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head || null == head.next) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode(-1);
        ListNode resultTail = result;
        int counter = 0;
        while (head != null) {
            counter++;
            if (counter >= m && counter <= n) {
                stack.push(head);
            } else {
                if (counter == n + 1) {
                    while (!stack.empty()) {
                        resultTail.next = stack.pop();
                        resultTail = resultTail.next;
                    }
                }
                resultTail.next = head;
                resultTail = resultTail.next;
            }
            head = head.next;
        }
        while (!stack.empty()) {
            resultTail.next = stack.pop();
            resultTail = resultTail.next;
        }
        resultTail.next = null;
        return result.next;
    }

    public static void main(String[] args) {
        LC92ReverseLinkedListII solution = new LC92ReverseLinkedListII();
        System.out.println(solution.reverseBetween(ListNode.fromVals(5), 1, 1));
        System.out.println(solution.reverseBetween(ListNode.fromVals(1, 2, 3, 4, 5), 1, 5));
        System.out.println(solution.reverseBetween(ListNode.fromVals(1, 2, 3, 4, 5), 2, 4));
        System.out.println(solution.reverseBetween(ListNode.fromVals(1, 2, 3, 4, 5), 2, 2));
    }
}
