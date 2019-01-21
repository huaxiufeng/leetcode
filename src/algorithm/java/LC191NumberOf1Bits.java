package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/21.
 */
public class LC191NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LC191NumberOf1Bits solution = new LC191NumberOf1Bits();
        System.out.println(solution.hammingWeight(11)); // 3
    }
}
