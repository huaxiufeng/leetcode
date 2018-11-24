package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/24.
 */
public class LC111MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else if (null == root.left && null == root.right) {
            return 1;
        }
        int minDepthLeft = Integer.MAX_VALUE;
        int minDepthRight = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepthLeft = minDepth(root.left);
        }
        if (root.right != null) {
            minDepthRight = minDepth(root.right);
        }
        return 1+ Math.min(minDepthLeft, minDepthRight);
    }

    public static void main(String[] args) throws Exception {
        LC111MinimumDepthOfBinaryTree solution = new LC111MinimumDepthOfBinaryTree();
        System.out.println(solution.minDepth(TreeNode.fromLevelSequence("[1,2,null]")));
        System.out.println(solution.minDepth(TreeNode.fromLevelSequence("[3,9,20,null,null,15,7]")));
    }
}
