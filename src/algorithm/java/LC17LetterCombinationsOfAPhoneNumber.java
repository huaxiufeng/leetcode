package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LC17LetterCombinationsOfAPhoneNumber {

    private static List<Character>[] map = new List[10];
    static {
        map[2] = Arrays.asList('a', 'b', 'c');
        map[3] = Arrays.asList('d', 'e', 'f');
        map[4] = Arrays.asList('g', 'h', 'i');
        map[5] = Arrays.asList('j', 'k', 'l');
        map[6] = Arrays.asList('m', 'n', 'o');
        map[7] = Arrays.asList('p', 'q', 'r', 's');
        map[8] = Arrays.asList('t', 'u', 'v');
        map[9] = Arrays.asList('w', 'x', 'y', 'z');
    }

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        doLetterCombinations(digits, 0, new StringBuilder(), resultList);
        return resultList;
    }

    private void doLetterCombinations(String digits, int index, StringBuilder builder, List<String> resultList) {
        if (index >= digits.length()) {
            if (builder.length() > 0) {
                resultList.add(builder.toString());
            }
            return;
        }
        int n = digits.charAt(index) - '0';
        for (char c : map[n]) {
            builder.append(c);
            doLetterCombinations(digits, index + 1, builder, resultList);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LC17LetterCombinationsOfAPhoneNumber solution = new LC17LetterCombinationsOfAPhoneNumber();
        System.out.println(solution.letterCombinations("")); // []
        System.out.println(solution.letterCombinations("23")); // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }
}
