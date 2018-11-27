package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/26.
 */
public class LC99RecoverBinarySearchTree {

    private TreeNode preNode;
    private TreeNode big;
    private TreeNode small;

    public void recoverTree(TreeNode root) {
        inorderHelper(root);
        if (big != null && small != null) {
            int temp = big.val;
            big.val = small.val;
            small.val = temp;
        }
    }

    private void inorderHelper(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderHelper(root.left);

        if (preNode != null && preNode.val > root.val) {
            if (null == big) { // 只有一个大的是需要被交换的
                big = preNode;
            }
            small = root;
        }
        preNode = root;

        inorderHelper(root.right);
    }

    public static void main(String[] args) throws Exception {
        LC99RecoverBinarySearchTree solution = new LC99RecoverBinarySearchTree();
        solution.recoverTree(TreeNode.fromLevelSequence("[1,3,null,null,2,null,null]"));
    }
}
