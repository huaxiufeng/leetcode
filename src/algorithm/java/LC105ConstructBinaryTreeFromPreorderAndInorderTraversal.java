package algorithm.java;

import algorithm.java.data.TreeNode;

public class LC105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        int len = preEnd - preBegin + 1;
        if (len <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        if (len == 1) {
            return root;
        }
        int inRootIndex = inBegin;
        while (inorder[inRootIndex] != preorder[preBegin]) {
            inRootIndex++;
        }
        int leftLen = inRootIndex - inBegin;
        root.left = doBuildTree(preorder, preBegin + 1, preBegin + leftLen, inorder, inBegin, inBegin + leftLen - 1);
        root.right = doBuildTree(preorder, preBegin + 1 + leftLen, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        LC105ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new LC105ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
