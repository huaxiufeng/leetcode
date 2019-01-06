package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 19/1/6.
 */
public class LC241DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        if (null == input || input.length() == 0) {
            return new ArrayList<>();
        }
        char op = 0;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!isOperator(input.charAt(i))) {
                continue;
            }
            op = input.charAt(i);
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1));
            for (int l : left) {
                for (int r : right) {
                    resultList.add(calc(l, r, op));
                }
            }
        }
        if (0 == op) {
            resultList.add(Integer.valueOf(input));
        }
        return resultList;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private int calc(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        }
        return 0;
    }

    public static void main(String[] args) {
        LC241DifferentWaysToAddParentheses solution = new LC241DifferentWaysToAddParentheses();
        System.out.println(solution.diffWaysToCompute("2-1-1")); // [0, 2]
        System.out.println(solution.diffWaysToCompute("2*3-4*5")); // [-34, -14, -10, -10, 10]
    }
}
