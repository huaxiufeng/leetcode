package algorithm.java;

/**
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.

 * Created by huaxiufeng on 17/8/6.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if (null == s || 0 == s.length()) {
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (0 == words[i].length()) {
                continue;
            }
            sb.append(reverseStr(words[i]));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return reverseStr(sb.toString());
    }

    private String reverseStr(String w) {
        StringBuilder sb = new StringBuilder(w);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        System.out.println(solution.reverseWords(" 1"));
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
