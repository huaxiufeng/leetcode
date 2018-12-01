package algorithm.java;

import java.util.Stack;

import algorithm.java.data.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 * Created by huaxiufeng on 18/12/1.
 */
public class LC173BinarySearchTreeIterator {

    public static class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            addPath(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            addPath(node.right);
            return node.val;
        }

        private void addPath(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

    private void foo(TreeNode root) {
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(">>>>>>>>>>");
    }

    public static void main(String[] args) throws Exception {
        LC173BinarySearchTreeIterator solution = new LC173BinarySearchTreeIterator();
        solution.foo(TreeNode.fromLevelSequence("[4,2,6,1,3,5,7]"));
        solution.foo(TreeNode.fromLevelSequence("[4,null,6,5,7]"));
    }
}
