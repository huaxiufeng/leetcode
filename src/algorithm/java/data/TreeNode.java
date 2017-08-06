package algorithm.java.data;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by amyhuiye on 2017/5/28.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    /**
     * 根据层次遍历的结果，生成树
     * 如果上层的节点为null，则下层不需要对应的left和right，下层的节点个数等于上层非null的节点数*2
     * [10,5,-3,3,2,null,11,3,-2,null,1,null,9]
     *
     *          10
     *         /  \
     *        5   -3
     *       / \    \
     *      3   2   11
     *     / \   \   \
     *    3  -2   1   9
     * @param sequence
     * @return
     */
    public static TreeNode fromLevelSequence(String sequence) throws Exception {
        if (null == sequence || 0 == sequence.length()) {
            throw new Exception("sequence长度错误，不能为空");
        }
        if (!sequence.startsWith("[") || !sequence.endsWith("]")) {
            throw new Exception("sequence格式错误，无'['或者']'");
        }
        sequence = sequence.substring(1, sequence.length() - 1);
        Queue<String> valQueue = new ArrayDeque<>(Arrays.asList(sequence.split(",")));
        if (valQueue.size() == 1 && valQueue.element().equals("null")) {
            throw new Exception("根节点不能为null");
        }
        TreeNode root = createTreeNode(valQueue.poll());
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        while (!valQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            node.left = createTreeNode(valQueue.poll());
            if (node.left != null) {
                treeNodeQueue.offer(node.left);
            }
            node.right = createTreeNode(valQueue.poll());
            if (node.right != null) {
                treeNodeQueue.offer(node.right);
            }
        }
        return root;
    }

    private static TreeNode createTreeNode(String val) throws Exception {
        if ("null".equals(val)) {
            return null;
        }
        try {
            return new TreeNode(Integer.valueOf(val));
        } catch (NumberFormatException e) {
        }
        throw new Exception(val + "不是合法的数字");
    }

    public static void main(String[] args) throws Exception {
        fromLevelSequence("[10,5,-3,3,2,null,11,3,-2,null,1,null,9]");
    }
}
