package algorithm.java;

import algorithm.java.data.TreeNode;

public class LC110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root, new int[1]);
    }

    private boolean checkBalanced(TreeNode root, int[] height) {
        height[0] = 0;
        if (null == root) {
            return true;
        }
        if (!checkBalanced(root.left, height)) {
            return false;
        }
        int leftHeight = height[0];
        if (!checkBalanced(root.right, height)) {
            return false;
        }
        int rightHeight = height[0];
        height[0] = Math.max(leftHeight, rightHeight) + 1;
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public static void main(String[] args) throws Exception {
        LC110BalancedBinaryTree solution = new LC110BalancedBinaryTree();
        System.out.println(solution.isBalanced(TreeNode.fromLevelSequence("[3,9,20,null,null,15,7]"))); // true
        System.out.println(solution.isBalanced(TreeNode.fromLevelSequence("[1,2,2,3,3,null,null,4,4]"))); // false
    }
}
