package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC32LongestValidParentheses {

    // TODO
    public int longestValidParentheses(String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }
        int maxLen = 0;
        int curMaxLen = 0;
        int curLeftCount = 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                curLeftCount++;
            } else {
                if (curLeftCount > 0) {
                    curLeftCount--;
                    curMaxLen += 2;
                } else {
                    maxLen = Math.max(maxLen, curMaxLen);
                    curMaxLen = 0;
                }
            }
        }
        return Math.max(maxLen, curMaxLen);
    }

    public static void main(String[] args) {
        LC32LongestValidParentheses solution = new LC32LongestValidParentheses();
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
