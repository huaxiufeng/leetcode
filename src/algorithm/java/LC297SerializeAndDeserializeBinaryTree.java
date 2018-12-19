package algorithm.java;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/12/19.
 */
public class LC297SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        doPreOrderSerialize(root, builder);
        return builder.toString();
    }

    private void doPreOrderSerialize(TreeNode root, StringBuilder builder) {
        if (null == root) {
            builder.append("n,");
        } else {
            builder.append(root.val).append(',');
            doPreOrderSerialize(root.left, builder);
            doPreOrderSerialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return doPreOrderDeserialize(data, new int[]{0});
    }

    private TreeNode doPreOrderDeserialize(String data, int[] cursor) {
        if (cursor[0] >= data.length()) {
            return null;
        }
        if (data.charAt(cursor[0]) == 'n') {
            cursor[0] += 2;
            return null;
        }
        int splitPos = data.indexOf(',', cursor[0]);
        TreeNode node = new TreeNode(Integer.valueOf(data.substring(cursor[0], splitPos)));
        cursor[0] = splitPos + 1;
        node.left = doPreOrderDeserialize(data, cursor);
        node.right = doPreOrderDeserialize(data, cursor);
        return node;
    }

    public static void main(String[] args) {
        LC297SerializeAndDeserializeBinaryTree solution = new LC297SerializeAndDeserializeBinaryTree();
        String str = "1,2,n,n,3,n,n,";
        TreeNode root = solution.deserialize(str);
        System.out.println(solution.serialize(root));
    }
}
