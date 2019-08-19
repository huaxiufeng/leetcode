package algorithm.java;

import algorithm.java.data.Node;

public class LC559MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        int childMaxDepth = 0;
        if (root.children != null) {
            for (Node node : root.children) {
                childMaxDepth = Math.max(childMaxDepth, maxDepth(node));
            }
        }
        return childMaxDepth + 1;
    }
}
