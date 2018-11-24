package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/24.
 */
public class LC108ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode doSortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doSortedArrayToBST(nums, begin, mid - 1);
        root.right = doSortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        LC108ConvertSortedArrayToBinarySearchTree solution = new LC108ConvertSortedArrayToBinarySearchTree();
        TreeNode root = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
