package algorithm.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Example 1:

 Input: "()())()"
 Output: ["()()()", "(())()"]

 * Created by huaxiufeng on 19/3/19.
 */
public class LC301RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        boolean found = false;
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            s = queue.poll();
            // 加速剪支，否则会超时
            if (visited.contains(s)) {
                continue;
            }
            visited.add(s);
            if (isValid(s)) {
                found = true;
                result.add(s);
            }

            // 如果已经找到了，就不需要再往下找了，因为后面的长度会更短
            // 只需要把当前队列里面的消化完即可
            if (found) {
                continue;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    queue.add(s.substring(0, i) + s.substring(i+1));
                }
            }
        }
        return new ArrayList<>(result);
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        LC301RemoveInvalidParentheses solution = new LC301RemoveInvalidParentheses();
        System.out.println(solution.removeInvalidParentheses("(a)())()")); // ["(a)()()", "(a())()"]
        System.out.println(solution.removeInvalidParentheses("()())()")); // ["()()()", "(())()"]
        System.out.println(solution.removeInvalidParentheses(")(")); // [""]
    }
}

