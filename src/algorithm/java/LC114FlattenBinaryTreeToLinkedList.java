package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class LC114FlattenBinaryTreeToLinkedList {

    public void flatten0(TreeNode root) {
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

    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    private TreeNode[] doFlatten(TreeNode root) {
        if (null == root) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] resLeft = doFlatten(root.left);
        TreeNode[] resRight = doFlatten(root.right);
        root.left = null;
        TreeNode tail = root;
        if (resLeft[0] != null && resLeft[1] != null) {
            tail.right = resLeft[0];
            tail = resLeft[1];
        }
        if (resRight[0] != null && resRight[1] != null) {
            tail.right = resRight[0];
            tail = resRight[1];
        }
        return new TreeNode[]{root, tail};
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = TreeNode.fromLevelSequence("[1,2,5,3,4,null,6]");
        LC114FlattenBinaryTreeToLinkedList solution = new LC114FlattenBinaryTreeToLinkedList();
        solution.flatten(root);
        System.out.println(root.toString());
    }
}
