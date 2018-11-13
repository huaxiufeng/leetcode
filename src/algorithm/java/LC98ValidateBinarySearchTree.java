package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by amyhuiye on 2018/11/14.
 */
public class LC98ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValid(TreeNode root, long min, long max) {
        if (null == root) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return checkValid(root.left, min, root.val) && checkValid(root.right, root.val, max);
    }

    public static void main(String[] args) throws Exception {
        LC98ValidateBinarySearchTree solution = new LC98ValidateBinarySearchTree();
        System.out.println(solution.isValidBST(TreeNode.fromLevelSequence("[5,1,4,null,null,3,6]"))); // false
        System.out.println(solution.isValidBST(TreeNode.fromLevelSequence("[2,1,3]"))); // true
    }
}
