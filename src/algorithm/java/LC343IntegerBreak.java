package algorithm.java;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * Created by huaxiufeng on 19/1/29.
 */
public class LC343IntegerBreak {

    /**
     * 先考虑把N分成两个部分，f=x(N-x)
     * 当x = N/2的时候，乘积最大化
     * 也就是当N为偶数的时候最大乘积为(N/2) * (N/2)，当N为奇数的时候最大乘积为(N-1)/2 * (N+1)/2
     * (N/2) * (N/2) >= N, 得到 N>=4
     * (N-1)/2 * (N+1)/2 >= N, 得到 N>=5
     * 也就是说当N大于等于4的时候可以通过拆解一半得到更大的乘积，所以因子肯定小于4，因此从1，2，3中选
     * 1肯定不行，如果因子为1的话乘积会变小，因此只能是从2，3中选
     * 对于6来说 3*3 > 2*2*2，因此尽量以3作为因子
     * 另一方面:
     * 2^3 < 3^2
     * 4^3 < 3^4
     * 5^3 < 3^5
     * 6^3 < 3^6
     * ... 证明3确实是最大化的因子
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        }
        int product = 1;
        while (n > 4) {
            product = product * 3;
            n = n - 3;
        }
        product = product * n;
        return product;
    }

    public static void main(String[] args) {
        LC343IntegerBreak solution = new LC343IntegerBreak();
        System.out.println(solution.integerBreak(2)); // 1
        System.out.println(solution.integerBreak(10)); // 36
        System.out.println(solution.integerBreak(11)); // 54
    }
}
