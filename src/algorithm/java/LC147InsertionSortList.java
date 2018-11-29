package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by amyhuiye on 2018/11/29.
 */
public class LC147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode input = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head.next = null;
        while (input != null) {
            ListNode node = input;
            input = input.next;
            doInsertion(dummy, node);
        }
        return dummy.next;
    }

    private void doInsertion(ListNode dummy, ListNode node) {
        ListNode head = dummy.next;
        if (node.val <= head.val) {
            dummy.next = node;
            node.next = head;
        } else {
            while (head != null) {
                if (null == head.next) {
                    node.next = null;
                    head.next = node;
                    break;
                } else {
                    if (node.val <= head.next.val) {
                        node.next = head.next;
                        head.next = node;
                        break;
                    }
                }
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        LC147InsertionSortList solution = new LC147InsertionSortList();
        System.out.println(solution.insertionSortList(ListNode.fromVals(-1, 5, 3, 4, 0)));
        System.out.println(solution.insertionSortList(ListNode.fromVals(4, 2, 1, 3)));
    }
}
