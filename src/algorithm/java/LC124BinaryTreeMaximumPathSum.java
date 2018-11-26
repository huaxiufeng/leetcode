package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/24.
 */
public class LC124BinaryTreeMaximumPathSum {

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxPathSum;
    }

    /**
     * 返回值：以root为终点的path之和（左边或者右边，取较大的一边）
     * maxPathSum: 以当前节点为根节点的path之和的最大值，把每个节点的值都比较一遍就得到最终的结果
     * @param root
     * @return
     */
    private int maxPathSumHelper(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = Math.max(maxPathSumHelper(root.left), 0); // 和0进行比较是因左边的pathSum可能为负数，此时只取根节点即可
        int right = Math.max(maxPathSumHelper(root.right), 0);
        maxPathSum = Math.max(maxPathSum, left + root.val + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) throws Exception {
        LC124BinaryTreeMaximumPathSum solution = new LC124BinaryTreeMaximumPathSum();
        System.out.println(solution.maxPathSum(TreeNode.fromLevelSequence("[-3]")));
        System.out.println(solution.maxPathSum(TreeNode.fromLevelSequence("[1]")));
        System.out.println(solution.maxPathSum(TreeNode.fromLevelSequence("[1,2,3]")));
        System.out.println(solution.maxPathSum(TreeNode.fromLevelSequence("[-10,9,20,null,null,15,7]")));
    }
}
