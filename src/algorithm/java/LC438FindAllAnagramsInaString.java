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

    public List<Integer> findAnagrams0(String s, String p) {
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


    public List<Integer> findAnagrams(String s, String p) {
        // 使用滑动窗口
        ArrayList<Integer> result = new ArrayList<>();

        // 判断输入参数的合法性
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        // 字符串hash
        // 记录p中每个字符出现了多少次
        int[] chars = new int[26];
        // 当窗口滑动的时候，end对应的位置自减，start对应的位置自增
        // 当字符对应的位置为正数，表示当前窗口想要构成变位词还需要这个字符
        // 当字符对应的位置为负数，表示窗口中该字符的数量超出了变位词中的数量
        for (Character c : p.toCharArray()) {
            // 把变位词对应的字符自增
            chars[c - 'a']++;
        }

        // start: 窗口的起始位置
        // end: 窗口的结束位置
        // len: 变位词的长度
        // diff: 当前窗口于变位词相差的字符个数，如果为0的话，当前窗口为变位词
        int start = 0, end = 0, len = p.length(), diff = len;

        // 生成第一个窗口
        for (end = 0; end < len; end++) {
            char c = s.charAt(end);

            chars[c - 'a']--;

            // 如果对应的位置大于等于0，说明该字符在变位词中，并且还需要这个字符
            if (chars[c - 'a'] >= 0) {
                // 离结果更进一步，diff自减
                diff--;
            }
        }

        // 如果diff为0的话，当前窗口为变位词，此时start为0
        if (diff == 0) {
            result.add(0);
        }

        // 此刻start和end分别位于窗口的起始和结束，每次移动start和end都要自增
        while (end < s.length()) {
            // sc是窗口起始位置的字符，窗口移动后将要被扔掉
            char sc = s.charAt(start);

            // 如果起始的字符对应的位置>=0，说明变位词包含了这个字符，扔掉它我们离结果远了一步，diff自增
            if (chars[sc - 'a'] >= 0) {
                diff++;
            }

            // sc要被扔掉了，对应位置的值自增
            chars[sc - 'a']++;

            // 窗口的起始位置右移
            start++;

            // ec是窗口结束位置的字符，窗口移动后要加进来
            char ec = s.charAt(end);

            // 因为结束字符将要加入窗口，结束字符对于的位置自减
            chars[ec - 'a']--;

            // 如果对应的位置大于等于0，说明该字符在变位词中，并且还需要这个字符
            if (chars[ec - 'a'] >= 0) {
                // 离结果更进一步，diff自减
                diff--;
            }

            // 如果diff为0的话，当前窗口为变位词
            if (diff == 0) {
                result.add(start);
            }

            // 窗口的结束位置右移
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        LC438FindAllAnagramsInaString solution = new LC438FindAllAnagramsInaString();
        System.out.println(solution.findAnagrams("eacb", "abc")); // [1]
        System.out.println(solution.findAnagrams("cbaeacb", "abc")); // [0,4]
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(solution.findAnagrams("abab", "ab")); // [0,1,2]
    }
}
