package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".

 * Created by huaxiufeng on 17/8/6.
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        char[] result = s.toCharArray();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> vowelList = new ArrayList<>();
        for (int i = result.length-1; i >= 0; i--) {
            if (vowelSet.contains(result[i])) {
                vowelList.add(result[i]);
                result[i] = 0;
            }
        }
        for (int i = 0, vi = 0; i < result.length; i++) {
            if (result[i] == 0) {
                result[i] = vowelList.get(vi++);
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        System.out.println(solution.reverseVowels("leetcode"));
        System.out.println(solution.reverseVowels("aA"));
    }
}
