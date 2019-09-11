package algorithm.java;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.java.data.TreeLinkNode;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class LC116PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeLinkNode pre = null;
            for (int i = 0; i < len; i++) {
                TreeLinkNode node = queue.poll();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        LC116PopulatingNextRightPointersInEachNode solution = new LC116PopulatingNextRightPointersInEachNode();
        solution.connect(TreeLinkNode.fromLevelSequence("[1,2,3,4,5,6,7,null,null,null,null,null,null,null,null]"));
    }
}
