package algorithm.java;

import java.util.LinkedList;
import java.util.List;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/21.
 */
public class LC95UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        return doGenerateTrees(1, n);
    }

    private LinkedList<TreeNode> doGenerateTrees(int begin, int end) {
        LinkedList<TreeNode> resultList = new LinkedList<>();
        if (begin > end) {
            resultList.add(null);
            return resultList;
        }
        for (int i = begin; i <= end; i++) {
            LinkedList<TreeNode> leftList = doGenerateTrees(begin, i - 1);
            LinkedList<TreeNode> rightList = doGenerateTrees(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    resultList.add(root);
                }
            }
        }
        return resultList;
    }
}
