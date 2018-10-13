package algorithm.java;

import java.util.Stack;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/10/13.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        InvertBinaryTree solution = new InvertBinaryTree();
        solution.invertTree(TreeNode.fromLevelSequence("[10,5,-3,3,2,null,11,3,-2,null,1,null,9]"));
    }
}
