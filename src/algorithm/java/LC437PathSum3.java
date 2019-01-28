package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

       10
      /  \
     5   -3
    / \    \
   3   2   11
  / \   \   \
 3  -2   1   9

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 *
 * Created by huaxiufeng on 17/8/6.
 */
public class LC437PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        return (root.val == sum ? 1 : 0)
                + pathSum(root.left, sum)
                + pathSumFromRoot(root.left, sum - root.val)
                + pathSum(root.right, sum)
                + pathSumFromRoot(root.right, sum - root.val);
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        return (root.val == sum ? 1 : 0)
                + pathSumFromRoot(root.left, sum - root.val)
                + pathSumFromRoot(root.right, sum - root.val);
    }

    public static void main(String[] args) throws Exception {
        LC437PathSum3 solution = new LC437PathSum3();
        System.out.println(solution.pathSum(TreeNode.fromLevelSequence("[10,5,-3,3,2,null,11,3,-2,null,1,null,9]"), 8));
        System.out.println(solution.pathSum(TreeNode.fromLevelSequence("[1]"), 1));
    }
}
