package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/21.
 */
public class LC168ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            char c = (char) ('A' + (n - 1) % 26);
            stringBuilder.append(c);
            n = (n - 1) / 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        LC168ExcelSheetColumnTitle solution = new LC168ExcelSheetColumnTitle();
        System.out.println(solution.convertToTitle(26)); // Z
        System.out.println(solution.convertToTitle(1)); // A
        System.out.println(solution.convertToTitle(27)); // AA
        System.out.println(solution.convertToTitle(701)); // ZY
    }
}
