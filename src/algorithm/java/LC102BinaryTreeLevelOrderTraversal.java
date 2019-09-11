package algorithm.java;

import algorithm.java.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(levelList);
        }
        return resultList;
    }

    public static void main(String[] args) throws Exception {
        LC102BinaryTreeLevelOrderTraversal solution = new LC102BinaryTreeLevelOrderTraversal();
        System.out.println(solution.levelOrder(TreeNode.fromLevelSequence("[3,9,20,null,null,15,7]")));
    }
}
