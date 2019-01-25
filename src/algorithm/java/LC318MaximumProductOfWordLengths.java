package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/25.
 */
public class LC318MaximumProductOfWordLengths {

    // Bit Manipulation
    public int maxProduct(String[] words) {
        int[] values = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int value = 0;
            for (int j = 0; j < word.length(); j++) {
                value |= 1 << (word.charAt(j) - 'a');
            }
            values[i] = value;
        }
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if ((values[i] & values[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC318MaximumProductOfWordLengths solution = new LC318MaximumProductOfWordLengths();
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})); // 16
        System.out.println(solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})); // 4
        System.out.println(solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})); // 0
    }
}
