package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by amyhuiye on 2017/5/28.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left) {
            return sumOfLeftLeaves(root.right);
        } else {
            if (null == root.left.left && null == root.left.right) {
                return root.left.val + sumOfLeftLeaves(root.right);
            } else {
                return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}
