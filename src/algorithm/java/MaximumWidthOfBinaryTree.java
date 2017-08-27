package algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithm.java.data.TreeNode;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary
 * tree, but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the
 * length calculation.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * <p>
 * Note: Answer will in the range of 32-bit signed integer.
 * <p>
 * Created by huaxiufeng on 17/8/24.
 */
public class MaximumWidthOfBinaryTree {

    /*
    * Memory issue
    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        TreeNode EMPTY_NODE = new TreeNode(Integer.MIN_VALUE);
        List<TreeNode> currentLine = new ArrayList<>();
        currentLine.add(root);
        int maxWidth = 0;
        while (true) {
            int leftEmpty = 0, rightEmpty = 0;
            int leftIndex = 0;
            for (leftIndex = 0; leftIndex < currentLine.size(); leftIndex++) {
                if (currentLine.get(leftIndex) == EMPTY_NODE) {
                    leftEmpty++;
                } else {
                    break;
                }
            }
            for (int i = currentLine.size() - 1; i > leftIndex; i--) {
                if (currentLine.get(i) == EMPTY_NODE) {
                    rightEmpty++;
                } else {
                    break;
                }
            }
            int lineWidth = currentLine.size() - leftEmpty - rightEmpty;
            if (0 == lineWidth) {
                break;
            }
            if (lineWidth > maxWidth) {
                maxWidth = lineWidth;
            }
            List<TreeNode> nextLine = new ArrayList<>();
            for (TreeNode treeNode : currentLine) {
                if (treeNode != EMPTY_NODE) {
                    if (treeNode.left != null) {
                        nextLine.add(treeNode.left);
                    } else {
                        nextLine.add(EMPTY_NODE);
                    }
                    if (treeNode.right != null) {
                        nextLine.add(treeNode.right);
                    } else {
                        nextLine.add(EMPTY_NODE);
                    }
                } else {
                    nextLine.add(EMPTY_NODE);
                    nextLine.add(EMPTY_NODE);
                }
            }
            currentLine = nextLine;
        }
        return maxWidth;
    }
    */

    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Map<Integer, int[]> levelBeginEndIndexMap = new HashMap<>();
        traverse(root, 1, 1, levelBeginEndIndexMap);
        int maxWidth = 0;
        for (int[] beginEndIndex : levelBeginEndIndexMap.values()) {
            if (beginEndIndex[1] - beginEndIndex[0] + 1 > maxWidth) {
                maxWidth = beginEndIndex[1] - beginEndIndex[0] + 1;
            }
        }
        return maxWidth;
    }

    private void traverse(TreeNode root, int level, int index, Map<Integer, int[]> levelBeginEndIndexMap) {
        if (null == root) {
            return;
        }
        if (levelBeginEndIndexMap.containsKey(level)) {
            levelBeginEndIndexMap.get(level)[1] = index;
        } else {
            levelBeginEndIndexMap.put(level, new int[]{index, index});
        }
        traverse(root.left, level + 1, 2 * index, levelBeginEndIndexMap);
        traverse(root.right, level + 1, 2 * index + 1, levelBeginEndIndexMap);
    }

    public static void main(String[] args) throws Exception {
        MaximumWidthOfBinaryTree solution = new MaximumWidthOfBinaryTree();
        System.out.println(solution.widthOfBinaryTree(TreeNode.fromLevelSequence("[1]")));
        System.out.println(solution.widthOfBinaryTree(TreeNode.fromLevelSequence("[1,3,2,5,3,null,9]")));
        System.out.println(solution.widthOfBinaryTree(TreeNode.fromLevelSequence("[1,3,2,5,null,null,null]")));
    }
}
