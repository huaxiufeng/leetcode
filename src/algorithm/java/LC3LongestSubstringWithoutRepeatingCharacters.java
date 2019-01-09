package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * Created by huaxiufeng on 17/8/27.
 */
public class LC3LongestSubstringWithoutRepeatingCharacters {

    /*
    brute force
    public int lengthOfLongestSubstring(String s) {
        if (null == s) return 0;
        if (s.length() <= 1) return s.length();
        int maxSubLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int subLen = 0;
            boolean charExsitArray[] = new boolean[256];
            for (int j = i; j < s.length(); j++) {
                if (charExsitArray[s.charAt(j)]) {
                    break;
                } else {
                    subLen++;
                    charExsitArray[s.charAt(j)] = true;
                }
            }
            if (subLen > maxSubLen) {
                maxSubLen = subLen;
            }
        }
        return maxSubLen;
    }
    */

    public int lengthOfLongestSubstring(String s) {
        if (null == s) return 0;
        if (s.length() <= 1) return s.length();
        int longestSub = 0;
        Set<Character> charSet = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                longestSub = Math.max(longestSub, j - i);
            } else {
                charSet.remove(s.charAt(i++));
            }
        }
        return longestSub;
    }

    public static void main(String[] args) {
        LC3LongestSubstringWithoutRepeatingCharacters solution = new LC3LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("au"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
