package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class LC112PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        } else if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
