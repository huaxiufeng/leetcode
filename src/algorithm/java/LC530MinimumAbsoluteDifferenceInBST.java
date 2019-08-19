package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
   \
     3
    /
   2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


 Note: There are at least two nodes in this BST.
 */
public class LC530MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        TreeNode leftMax = root, rightMin = root;
        if (root.left != null) {
            leftMax = root.left;
            while (leftMax.right != null) {
                leftMax = leftMax.right;
            }
        }
        if (root.right != null) {
            rightMin = root.right;
            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
        }
        int minDiff = Integer.MAX_VALUE;
        if (root != leftMax) {
            minDiff = Math.min(minDiff, root.val - leftMax.val);
        }
        if (root != rightMin) {
            minDiff = Math.min(minDiff, rightMin.val - root.val);
        }
        if (root.left != null && (root.left.left != null || root.left.right != null)) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.left));
        }
        if (root.right != null && (root.right.left != null || root.right.right != null)) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.right));
        }
        return minDiff;
    }

    public static void main(String[] args) throws Exception {
        LC530MinimumAbsoluteDifferenceInBST solution = new LC530MinimumAbsoluteDifferenceInBST();
        System.out.println(solution.getMinimumDifference(TreeNode.fromLevelSequence("[1,null,3,2,null]")));
    }
}
