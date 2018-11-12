package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/13.
 */
public class LC66PlusOne {

    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>(digits.length + 1);
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i] + carry;
            list.add(v % 10);
            carry = v / 10;
        }
        if (carry > 0) {
            list.add(carry);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LC66PlusOne solution = new LC66PlusOne();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
    }
}
