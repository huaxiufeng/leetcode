package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/25.
 */
public class LC313SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] primeIndexes = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        int count = 1;
        while (count < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primeIndexes.length; i++) {
                min = Math.min(min, nums[primeIndexes[i]] * primes[i]);
            }
            nums[count++] = min;
            for (int i = 0; i < primeIndexes.length; i++) {
                if (min == nums[primeIndexes[i]] * primes[i]) {
                    primeIndexes[i]++;
                }
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        LC313SuperUglyNumber solution = new LC313SuperUglyNumber();
        System.out.println(solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19})); // 32, [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
    }
}
