package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by amyhuiye on 2019/1/23.
 */
public class LC234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (null == fast) { // 偶数个, slow在后半部分第一个
            slow = reverse(slow);
        } else { // 奇数个，slow在中间
            slow = reverse(slow.next);
        }
        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode rhead = null;
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = rhead;
            rhead = node;
        }
        return rhead;
    }

    public static void main(String[] args) {
        LC234PalindromeLinkedList solution = new LC234PalindromeLinkedList();
        System.out.println(solution.isPalindrome(ListNode.fromVals(1,2,2,1)));
        System.out.println(solution.isPalindrome(ListNode.fromVals(1,2,3,2,1)));
        System.out.println(solution.isPalindrome(ListNode.fromVals(1,2,3,2,2)));
    }
}
