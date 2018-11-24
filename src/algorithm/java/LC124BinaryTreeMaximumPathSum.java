package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/24.
 */
public class LC124BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        // TODO
    }

    public static void main(String[] args) throws Exception {
        LC124BinaryTreeMaximumPathSum solution = new LC124BinaryTreeMaximumPathSum();
        System.out.println(solution.maxPathSum(TreeNode.fromLevelSequence("[1,2,3]")));
        System.out.println(solution.maxPathSum(TreeNode.fromLevelSequence("[-10,9,20,null,null,15,7]")));
    }
}
