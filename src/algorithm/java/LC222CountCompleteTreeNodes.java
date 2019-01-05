package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 19/1/4.
 */
public class LC222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int height = 0;
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
            height++;
        }
        return ((1 << height) - 1) + countLastLevelNodes(root, height);
    }

    private int countLastLevelNodes(TreeNode root, int height) {
        if (null == root) {
            return 0;
        }
        if (height == 0) {
            return 1;
        }
        TreeNode midNode = root.left;
        int k = height - 1;
        while (k > 0 && midNode != null) {
            midNode = midNode.right;
            k--;
        }
        if (midNode == null) {
            return countLastLevelNodes(root.left, height - 1);
        } else {
            return countLastLevelNodes(root.right, height - 1) + (1 << (height - 1));
        }
    }

    public static void main(String[] args) throws Exception {
        LC222CountCompleteTreeNodes solution = new LC222CountCompleteTreeNodes();
        System.out.println(solution.countNodes(TreeNode.fromLevelSequence("[1,2,3,4,5,6,null]"))); // 6
    }
}
