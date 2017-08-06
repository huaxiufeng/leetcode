package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
      1
     / \
    2   3
   / \
  4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.

 * Created by huaxiufeng on 17/8/6.
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int passRootDiameter = heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(passRootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private int heightOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
    }

    public static void main(String[] args) throws Exception {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        System.out.println(solution.diameterOfBinaryTree(TreeNode.fromLevelSequence("[1,2,3,4,5,null,null]")));
    }
}
