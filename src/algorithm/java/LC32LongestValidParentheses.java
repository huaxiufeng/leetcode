package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC32LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || 0 == i) {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = getDpValue(dp, i - 2) + 2;
            } else {
                int preDp = getDpValue(dp, i - 1);
                if (preDp > 0) {
                    int fIndex = i - 1 - preDp;
                    if (fIndex >= 0 && s.charAt(fIndex) == '(') {
                        dp[i] = getDpValue(dp, i - 1) + 2 + getDpValue(dp, fIndex - 1);
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    private int getDpValue(int[] dp, int index) {
        if (index < 0 || index >= dp.length) {
            return 0;
        }
        return dp[index];
    }

    public int longestValidParenthesesWithoutExtraSpace(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LC32LongestValidParentheses solution = new LC32LongestValidParentheses();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
