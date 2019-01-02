package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by amyhuiye on 2019/1/3.
 */
public class LC230KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2]; // 0:res 1:cursor
        traverse(root, k, tmp);
        return tmp[0];
    }

    private void traverse(TreeNode root, int k, int[] tmp) {
        if (null == root) {
            return;
        }
        traverse(root.left, k, tmp);
        tmp[1] = tmp[1] + 1;
        if (tmp[1] == k) {
            tmp[0] = root.val;
        }
        traverse(root.right, k, tmp);
    }

    public static void main(String[] args) throws Exception {
        LC230KthSmallestElementInABST solution = new LC230KthSmallestElementInABST();
        TreeNode tree = TreeNode.fromLevelSequence("[3,1,4,null,2]");
        System.out.println(solution.kthSmallest(tree, 1));
    }
}
