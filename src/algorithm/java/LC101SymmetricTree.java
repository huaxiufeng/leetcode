package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/14.
 */
public class LC101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return doCheckSymmetric(root.left, root.right);
    }

    private boolean doCheckSymmetric(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        } else if (null == root1 || null == root2) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doCheckSymmetric(root1.left, root2.right) && doCheckSymmetric(root1.right, root2.left);
    }
}
