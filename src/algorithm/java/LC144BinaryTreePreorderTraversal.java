package algorithm.java;

import algorithm.java.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by amyhuiye on 2018/11/29.
 */
public class LC144BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            resultList.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return resultList;
    }

    public List<Integer> preorderTraversal_(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        doPreorderTraversal(resultList, root);
        return resultList;
    }

    private void doPreorderTraversal(List<Integer> resultList, TreeNode root) {
        if (null == root) {
            return;
        }
        resultList.add(root.val);
        doPreorderTraversal(resultList, root.left);
        doPreorderTraversal(resultList, root.right);
    }

    public static void main(String[] args) throws Exception {
        LC144BinaryTreePreorderTraversal solution = new LC144BinaryTreePreorderTraversal();
        System.out.println(solution.preorderTraversal(TreeNode.fromLevelSequence("[1,null,2,3,null]")));
        System.out.println(solution.preorderTraversal(TreeNode.fromLevelSequence("[1,2,3,4,5,6,7]")));
    }
}
