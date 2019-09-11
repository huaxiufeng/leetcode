package algorithm.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by amyhuiye on 2018/11/28.
 */
public class LC139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreakTimeout(String s, List<String> wordDict) {
        if (null == s || s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC139WordBreak solution = new LC139WordBreak();
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
