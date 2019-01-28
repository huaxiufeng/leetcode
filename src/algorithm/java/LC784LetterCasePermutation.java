package algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huaxiufeng on 18/10/13.
 */
public class LC784LetterCasePermutation {

    public List<String> letterCasePermutation0(String S) {
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> indexPosMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isAlphabetic(S.charAt(i))) {
                indexPosMap.put(index++, i);
            }
        }
        if (0 == index) {
            result.add(S);
            return result;
        }
        int total = 2 << (index-1);
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < index; j++) {
                int pos = indexPosMap.get(j);
                char c = S.charAt(pos);
                if ((i >> j & 1) == 1) {
                    sb.setCharAt(pos, Character.toUpperCase(c));
                } else {
                    sb.setCharAt(pos, Character.toLowerCase(c));
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    public List<String> letterCasePermutation(String S) {
        List<String> resultList = new ArrayList<>();
        doLetterCasePermutation(resultList, new char[S.length()], S, 0);
        return resultList;
    }

    private void doLetterCasePermutation(List<String> resultList, char[] chars, String S, int start) {
        while (start < S.length() && !Character.isAlphabetic(S.charAt(start))) {
            chars[start] = S.charAt(start);
            start++;
        }
        if (start >= S.length()) {
            resultList.add(new String(chars));
            return;
        }
        chars[start] = Character.toLowerCase(S.charAt(start));
        doLetterCasePermutation(resultList, chars, S, start + 1);
        chars[start] = Character.toUpperCase(S.charAt(start));
        doLetterCasePermutation(resultList, chars, S, start + 1);
    }

    public static void main(String[] args) {
        LC784LetterCasePermutation solution = new LC784LetterCasePermutation();
        System.out.println(solution.letterCasePermutation("a1b2").toString());
        System.out.println(solution.letterCasePermutation("12345").toString());
    }
}
