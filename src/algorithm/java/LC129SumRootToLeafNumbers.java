package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by amyhuiye on 2018/11/28.
 */
public class LC129SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        } else if (null == root.left && null == root.right) {
            return root.val;
        }
        if (root.left != null) {
            root.left.val += root.val * 10;
        }
        if (root.right != null) {
            root.right.val += root.val * 10;
        }
        return sumNumbers(root.left) + sumNumbers(root.right);
    }

    public static void main(String[] args) throws Exception {
        LC129SumRootToLeafNumbers solution = new LC129SumRootToLeafNumbers();
        System.out.println(solution.sumNumbers(TreeNode.fromLevelSequence("[1,2,3]")));
        System.out.println(solution.sumNumbers(TreeNode.fromLevelSequence("[4,9,0,5,1,null,null]")));
    }
}
