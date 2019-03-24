package algorithm.java;

/**
 Count the number of prime numbers less than a non-negative number, n.

 Example:

 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Created by huaxiufeng on 19/3/24.
 */
public class LC204CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC204CountPrimes solution = new LC204CountPrimes();
        System.out.println(solution.countPrimes(3)); // 1
        System.out.println(solution.countPrimes(10)); // 4
    }
}
