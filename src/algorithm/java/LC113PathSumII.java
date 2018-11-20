package algorithm.java;

import java.util.ArrayList;
import java.util.List;

import algorithm.java.data.TreeNode;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class LC113PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        doPathSum(resultList, new ArrayList<>(), root, sum);
        return resultList;
    }

    private void doPathSum(List<List<Integer>> resultList, List<Integer> temp, TreeNode root, int sum) {
        if (null == root) {
            return;
        } else if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> result = new ArrayList<>(temp);
            result.add(root.val);
            resultList.add(result);
            return;
        }
        temp.add(root.val);
        {
            doPathSum(resultList, temp, root.left, sum - root.val);
            doPathSum(resultList, temp, root.right, sum - root.val);
        }
        temp.remove(temp.size() - 1);
    }
}
