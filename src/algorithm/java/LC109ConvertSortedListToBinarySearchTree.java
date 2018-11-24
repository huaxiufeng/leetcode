package algorithm.java;

import algorithm.java.data.ListNode;
import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/24.
 */
public class LC109ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        } else if (null == head.next) {
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        preSlow.next = null;
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        LC109ConvertSortedListToBinarySearchTree solution = new LC109ConvertSortedListToBinarySearchTree();
        solution.sortedListToBST(ListNode.fromVals(1,2,3));
        solution.sortedListToBST(ListNode.fromVals(-10,-3,0,5,9));
    }
}
