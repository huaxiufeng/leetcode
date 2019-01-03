package algorithm.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 19/1/3.
 */
public class LC236LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        stack.push(root);
        parentMap.put(root, null);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
        }
        Set<TreeNode> pParents = new HashSet<>();
        while (p != null) {
            pParents.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (pParents.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        LC236LowestCommonAncestorOfABinaryTree solution = new LC236LowestCommonAncestorOfABinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(solution.lowestCommonAncestor(root, root, root.left).val);
    }
}
