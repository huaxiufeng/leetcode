package algorithm.java;

import algorithm.java.data.TreeNode;

public class LC104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) throws Exception {
        LC104MaximumDepthOfBinaryTree solution = new LC104MaximumDepthOfBinaryTree();
        System.out.println(solution.maxDepth(TreeNode.fromLevelSequence("[3,9,20,null,null,15,7]"))); // 3
    }
}
