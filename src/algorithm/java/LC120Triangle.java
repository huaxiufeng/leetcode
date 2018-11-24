package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/24.
 */
public class LC120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        int minTotal = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> preLevel = triangle.get(i - 1);
            List<Integer> level = triangle.get(i);
            int levelMinTotal = Integer.MAX_VALUE;
            for (int j = 0; j < level.size(); j++) {
                level.set(j, level.get(j) + Math.min(getValue(preLevel, j-1), getValue(preLevel, j)));
                if (level.get(j) < levelMinTotal) {
                    levelMinTotal = level.get(j);
                }
            }
            minTotal = levelMinTotal;
        }
        return minTotal;
    }

    private int getValue(List<Integer> level, int index) {
        if (index >= 0 && index < level.size()) {
            return level.get(index);
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        LC120Triangle solution = new LC120Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }
}
