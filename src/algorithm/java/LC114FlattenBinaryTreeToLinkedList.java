package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class LC114FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode cursor = root;
        while (cursor.right != null) {
            cursor = cursor.right;
        }
        cursor.right = right;
    }
}
