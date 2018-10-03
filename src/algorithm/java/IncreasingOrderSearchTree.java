package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/10/3.
 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode incrLeft = increasingBST(root.left);
        TreeNode incrRight = increasingBST(root.right);
        root.left = null;
        root.right = incrRight;
        if (incrLeft != null) {
            incrLeft.left = null;
            TreeNode leftLast = incrLeft;
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = root;
            return incrLeft;
        } else {
            return root;
        }
    }
}
