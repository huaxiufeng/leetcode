package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huaxiufeng on 18/11/21.
 */
public class LC96UniqueBinarySearchTrees {

    public int numTrees(int n) {
        return calcNumTrees(new HashMap<>(), n);
    }

    private int calcNumTrees(Map<Integer, Integer> map, int n) {
        if (n <= 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for (int i = 0; i <= n - 1; i++) {
            count += (calcNumTrees(map, i) * calcNumTrees(map, n - i - 1));
        }
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        LC96UniqueBinarySearchTrees solution = new LC96UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(3)); // 5
    }
}
