package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(Arrays.asList(1));
        }
        if (numRows >= 2) {
            result.add(Arrays.asList(1,1));
        }
        for (int i = 2; i < numRows; i++) {
            Integer[] level = new Integer[i+1];
            level[0] = level[i] = 1;
            for (int j = 1; j < i; j++) {
                List<Integer> upLevel = result.get(i - 1);
                level[j] = upLevel.get(j-1) + upLevel.get(j);
            }
            result.add(Arrays.asList(level));
        }
        return result;
    }

    public static void main(String[] args) {
        LC118PascalsTriangle solution = new LC118PascalsTriangle();
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(2));
        System.out.println(solution.generate(5));
    }
}
