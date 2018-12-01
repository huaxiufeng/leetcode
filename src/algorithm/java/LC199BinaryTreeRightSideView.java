package algorithm.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == count-1) {
                    resultList.add(node.val);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) throws Exception {
        LC199BinaryTreeRightSideView solution = new LC199BinaryTreeRightSideView();
        System.out.println(solution.rightSideView(TreeNode.fromLevelSequence("[1,2,3,null,5,null,4]")));
    }
}
