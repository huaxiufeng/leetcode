package algorithm.java.data;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    TreeLinkNode(int x) { val = x; }

    public static TreeLinkNode fromLevelSequence(String sequence) throws Exception {
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
        TreeLinkNode root = createTreeNode(valQueue.poll());
        Queue<TreeLinkNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        while (!valQueue.isEmpty()) {
            TreeLinkNode node = treeNodeQueue.poll();
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

    private static TreeLinkNode createTreeNode(String val) throws Exception {
        if ("null".equals(val)) {
            return null;
        }
        try {
            return new TreeLinkNode(Integer.valueOf(val));
        } catch (NumberFormatException e) {
        }
        throw new Exception(val + "不是合法的数字");
    }

    public static void main(String[] args) throws Exception {
        fromLevelSequence("[10,5,-3,3,2,null,11,3,-2,null,1,null,9]");
    }
}
