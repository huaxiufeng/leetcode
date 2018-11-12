package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/13.
 */
public class LC77Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        doCombine(resultList, new ArrayList<>(), n, k, 1);
        return resultList;
    }

    private void doCombine(List<List<Integer>> resultList, List<Integer> temp, int n, int k, int cursor) {
        if (temp.size() >= k) {
            resultList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cursor; i <= n; i++) {
            temp.add(i);
            doCombine(resultList, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC77Combinations solution = new LC77Combinations();
        System.out.println(solution.combine(4, 2));
    }
}
