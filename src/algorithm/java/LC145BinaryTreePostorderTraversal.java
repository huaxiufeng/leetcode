package algorithm.java;

import algorithm.java.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by amyhuiye on 2018/11/29.
 */
public class LC145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            node.right = null;
            boolean leaf = left == null && right == null;
            if (!leaf) {
                stack.push(node);
                if (right != null) {
                    stack.push(right);
                }
                if (left != null) {
                    stack.push(left);
                }
            } else {
                resultList.add(node.val);
            }
        }
        return resultList;
    }

    public List<Integer> postorderTraversal_(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        doPostorderTraversal(resultList, root);
        return resultList;
    }

    private void doPostorderTraversal(List<Integer> resultList, TreeNode root) {
        if (null == root) {
            return;
        }
        doPostorderTraversal(resultList, root.left);
        doPostorderTraversal(resultList, root.right);
        resultList.add(root.val);
    }

    public static void main(String[] args) throws Exception {
        LC145BinaryTreePostorderTraversal solution = new LC145BinaryTreePostorderTraversal();
        System.out.println(solution.postorderTraversal(TreeNode.fromLevelSequence("[1,null,2,3,null]")));
        System.out.println(solution.postorderTraversal(TreeNode.fromLevelSequence("[1,2,3,4,5,6,7]")));
    }
}
