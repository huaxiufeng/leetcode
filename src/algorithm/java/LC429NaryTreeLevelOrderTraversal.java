package algorithm.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == root) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
