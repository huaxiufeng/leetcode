package algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huaxiufeng on 18/10/13.
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
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

    public static void main(String[] args) {
        LetterCasePermutation solution = new LetterCasePermutation();
        System.out.println(solution.letterCasePermutation("a1b2").toString());
        System.out.println(solution.letterCasePermutation("12345").toString());
    }
}
