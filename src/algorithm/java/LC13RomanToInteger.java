package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/11.
 */
public class LC13RomanToInteger {

    public int romanToInt(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int[] symbolValues = new int[256];
        symbolValues['I'] = 1;
        symbolValues['V'] = 5;
        symbolValues['X'] = 10;
        symbolValues['L'] = 50;
        symbolValues['C'] = 100;
        symbolValues['D'] = 500;
        symbolValues['M'] = 1000;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = symbolValues[s.charAt(i)];
            if (i + 1 < s.length()) {
                int nextV = symbolValues[s.charAt(i + 1)];
                if (nextV > v) {
                    v = nextV - v;
                    i++;
                }
            }
            result += v;
        }
        return result;
    }

    public static void main(String[] args) {
        LC13RomanToInteger solution = new LC13RomanToInteger();
        System.out.println(solution.romanToInt("III")); // 3
        System.out.println(solution.romanToInt("IV")); // 4
        System.out.println(solution.romanToInt("IX")); // 9
        System.out.println(solution.romanToInt("LVIII")); // 58
        System.out.println(solution.romanToInt("MCMXCIV")); // 1994
    }
}
