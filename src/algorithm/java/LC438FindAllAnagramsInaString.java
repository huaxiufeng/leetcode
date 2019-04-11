package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 * Created by huaxiufeng on 19/4/11.
 */
public class LC438FindAllAnagramsInaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (null == s || null == p || s.length() == 0 || p.length() == 0 || s.length() <= p.length()) {
            return result;
        }
        int[] pa = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pa[p.charAt(i) - 'a']++;
        }
        int[] sa = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sa[s.charAt(i) - 'a']++;
            if (i >= p.length() - 1) {
                int firstIndex = i - (p.length() - 1);
                if (equals(sa, pa)) {
                    result.add(firstIndex);
                }
                sa[s.charAt(firstIndex) - 'a']--;
            }
        }
        return result;
    }

    private boolean equals(int[] pa, int[] sa) {
        for (int i = 0; i < 26; i++) {
            if (pa[i] != sa[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC438FindAllAnagramsInaString solution = new LC438FindAllAnagramsInaString();
        System.out.println(solution.findAnagrams("cbaeacb", "abc")); // [0,4]
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(solution.findAnagrams("abab", "ab")); // [0,1,2]
    }
}
