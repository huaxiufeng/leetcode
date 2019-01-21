package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/21.
 */
public class LC171ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            number = number * 26 + (s.charAt(i) - 'A' + 1);
        }
        return number;
    }

    public static void main(String[] args) {
        LC171ExcelSheetColumnNumber solution = new LC171ExcelSheetColumnNumber();
        System.out.println(solution.titleToNumber("A")); // 1
        System.out.println(solution.titleToNumber("AB")); // 28
        System.out.println(solution.titleToNumber("ZY")); // 701
    }
}
