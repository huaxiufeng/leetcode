package algorithm.java;

import algorithm.java.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/14.
 */
public class LC94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        doInorderTraversal(resultList, root);
        return resultList;
    }

    private void doInorderTraversal(List<Integer> resultList, TreeNode root) {
        if (null == root) {
            return;
        }
        doInorderTraversal(resultList, root.left);
        resultList.add(root.val);
        doInorderTraversal(resultList, root.right);
    }

    public static void main(String[] args) {
    }
}
