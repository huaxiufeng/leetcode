package algorithm.java;

import java.util.ArrayList;
import java.util.List;

public class LC179LargestNumber {

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int n : nums) {
            list.add(String.valueOf(n));
        }
        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));
        if ("0".equals(list.get(0))) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LC179LargestNumber solution = new LC179LargestNumber();
        System.out.println(solution.largestNumber(new int[]{0, 0})); // 0
        System.out.println(solution.largestNumber(new int[]{10, 2})); // 210
        System.out.println(solution.largestNumber(new int[]{3,30,34,5,9})); // 9534330
    }
}
