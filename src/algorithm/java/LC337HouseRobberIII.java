package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 19/2/13.
 */
public class LC337HouseRobberIII {

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int sum = root.val;
        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(sum, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) throws Exception {
        LC337HouseRobberIII solution = new LC337HouseRobberIII();
        System.out.println(solution.rob(TreeNode.fromLevelSequence("[3,2,3,null,3,null,1]"))); // 7
    }
}
