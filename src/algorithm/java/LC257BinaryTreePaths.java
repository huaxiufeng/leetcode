package algorithm.java;

import java.util.ArrayList;
import java.util.List;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 19/3/11.
 */
public class LC257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        doBinaryTreePaths(resultList, new ArrayList<>(), root);
        return resultList;
    }

    private void doBinaryTreePaths(List<String> resultList, List<Integer> path, TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int n : path) {
                builder.append(n).append("->");
            }
            builder.append(root.val);
            resultList.add(builder.toString());
            return;
        }
        path.add(root.val);
        doBinaryTreePaths(resultList, path, root.left);
        doBinaryTreePaths(resultList, path, root.right);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) throws Exception {
        LC257BinaryTreePaths solution = new LC257BinaryTreePaths();
        System.out.println(solution.binaryTreePaths(TreeNode.fromLevelSequence("[1,2,3,null,5,null,null]"))); // ["1->2->5", "1->3"]
    }
}
