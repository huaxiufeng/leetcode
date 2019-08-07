package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 19/1/4.
 */
public class LC222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int leftLength = leftLength(root);
        int rightLength = rightLength(root);
        if (leftLength == rightLength) {
            return (1 << leftLength) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftLength(TreeNode root) {
        int length = 0;
        while (root != null) {
            length++;
            root = root.left;
        }
        return length;
    }

    private int rightLength(TreeNode root) {
        int length = 0;
        while (root != null) {
            length++;
            root = root.right;
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        LC222CountCompleteTreeNodes solution = new LC222CountCompleteTreeNodes();
        System.out.println(solution.countNodes(TreeNode.fromLevelSequence("[1,2,3,4,5,6,null]"))); // 6
    }
}
