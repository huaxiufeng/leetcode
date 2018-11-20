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
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeLinkNode> nextQueue = new LinkedList<>();
            TreeLinkNode nextQueueTail = null;
            while (!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                if (node.left != null) {
                    if (null != nextQueueTail) {
                        nextQueueTail.next = node.left;
                    }
                    nextQueueTail = node.left;
                    nextQueue.add(node.left);
                }
                if (node.right != null) {
                    if (null != nextQueueTail) {
                        nextQueueTail.next = node.right;
                    }
                    nextQueueTail = node.right;
                    nextQueue.add(node.right);
                }
            }
            queue = nextQueue;
        }
    }

    public static void main(String[] args) throws Exception {
        LC116PopulatingNextRightPointersInEachNode solution = new LC116PopulatingNextRightPointersInEachNode();
        solution.connect(TreeLinkNode.fromLevelSequence("[1,2,3,4,5,6,7,null,null,null,null,null,null,null,null]"));
    }
}
