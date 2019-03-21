package algorithm.java;

import java.util.Stack;

/**
 * Created by huaxiufeng on 19/3/21.
 */
public class LC20ValidParentheses {

    public boolean isValid(String s) {
        if (null == s || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.empty()) {
                    return false;
                } else {
                    char tc = stack.pop();
                    boolean match = (c == ')' && tc == '(') || (c == ']' && tc == '[') || (c == '}' && tc == '{');
                    if (!match) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        LC20ValidParentheses solution = new LC20ValidParentheses();
        System.out.println(solution.isValid("()")); // true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("(]")); // false
    }
}
