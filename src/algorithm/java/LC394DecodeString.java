package algorithm.java;

import java.util.Stack;

/**
 Given an encoded string, return its decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class LC394DecodeString {

    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        result.push("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
        }
        return result.pop();
    }

    public static void main(String[] args) {
        LC394DecodeString solution = new LC394DecodeString();
        System.out.println(solution.decodeString("3[a]2[b4[F]c]")); // aaabFFFFcbFFFFc
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); // zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
        System.out.println(solution.decodeString("leetcode")); // leetcode
        System.out.println(solution.decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(solution.decodeString("2[2[b]]")); // bbbb
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println(solution.decodeString("3[a2[c]]")); // accaccacc
    }
}
