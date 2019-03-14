package algorithm.java;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.

 Example 1:

 Input: "bcabc"
 Output: "abc"
 Example 2:

 Input: "cbacdcbc"
 Output: "acdb"

 * Created by amyhuiye on 2019/3/15.
 */
public class LC316RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        int[] count = new int[26]; // 每个字母出现的次数
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        boolean[] visited = new boolean[26]; // 判断是否已经将字母入栈
        Stack<Character> stack = new Stack<>(); // 结果栈，栈底的字母小，栈顶的字母大
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            count[index]--; // 待处理的数量减1
            if (visited[index]) { // 如果字母已经入栈了，不需要考虑
                continue;
            }
            // 如果当前的字母比栈顶的还要小，并且栈顶的字母后面还有，那么栈的字母就可以先出来，以后再放在后面
            while (!stack.empty() && c < stack.peek() && count[stack.peek()-'a'] > 0) {
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            visited[index] = true;
            stack.push(c);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        LC316RemoveDuplicateLetters solution = new LC316RemoveDuplicateLetters();
        System.out.println(solution.removeDuplicateLetters("bbcaac")); // bac
        System.out.println(solution.removeDuplicateLetters("bcabc")); // abc
        System.out.println(solution.removeDuplicateLetters("abc")); // abc
        System.out.println(solution.removeDuplicateLetters("cbacdcbc")); // acdb
    }
}
