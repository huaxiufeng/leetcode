package algorithm.java;

import java.util.ArrayList;
import java.util.List;

public class LC395LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstringTimeOut(String s, int k) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + k - 1; j < s.length(); j++) {
                int[] count = new int[26];
                for (int n = i; n <= j; n++) {
                    count[s.charAt(n) - 'a']++;
                }
                if (match(count, k)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    private boolean match(int[] count, int k) {
        int n = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                n++;
            } else if (count[i] > 0) {
                return false;
            }
        }
        return n > 0;
    }

    /**
     * 先遍历数组，统计每个字符出现的次数，把次数小于k的字符位置找出来，这些字符肯定不能出现在子串中，因此以它们的位置分割
     * 如果每个字符的次数都大于k，就返回整个字符串的长度
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) pos.add(i);
        }
        if (pos.size() == 0) {
            return s.length();
        }
        pos.add(0, -1);
        pos.add(s.length());
        for (int i = 1; i < pos.size(); i++) {
            int start = pos.get(i-1) + 1;
            int end = pos.get(i);
            int next = longestSubstring(s.substring(start, end), k);
            res = Math.max(res, next);
        }
        return res;
    }

    public static void main(String[] args) {
        LC395LongestSubstringWithAtLeastKRepeatingCharacters solution = new LC395LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(solution.longestSubstring("aaabb", 3)); // 3
        System.out.println(solution.longestSubstring("ababbc", 2)); // 5
    }
}
