package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 19/3/10.
 */
public class LC216CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        doCombinationSum3(resultList, new ArrayList<>(), k, n, 1);
        return resultList;
    }

    private void doCombinationSum3(List<List<Integer>> resultList, List<Integer> temp, int k, int n, int start) {
        if (k == 0 && n == 0) {
            resultList.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                doCombinationSum3(resultList, temp, k - 1, n - i, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LC216CombinationSumIII solution = new LC216CombinationSumIII();
        System.out.println(solution.combinationSum3(3, 15)); // [[1,5,9],[1,6,8],[2,4,9],[2,5,8],[2,6,7],[3,4,8],[3,5,7],[4,5,6]]
        System.out.println(solution.combinationSum3(3, 7)); // [[1,2,4]]
        System.out.println(solution.combinationSum3(3, 9)); // [[1,2,6], [1,3,5], [2,3,4]]
    }
}
