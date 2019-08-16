package algorithm.java;

/**
 Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class LC396RotateFunction {

    public int maxRotateFunctionTimeout(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int F = 0;
            for (int j = 0; j < n; j++) {
                int index = (j + n - i) % n;
                F += j * A[index];
            }
            result = Math.max(result, F);
        }
        return result;
    }

    public int maxRotateFunction(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] F = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            F[0] += i * A[i];
            sum += A[i];
        }
        int result = F[0];
        for (int i = 1; i < n; i++) {
            F[i] = F[i-1] + sum - n * A[n-i];
            result = Math.max(result, F[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LC396RotateFunction solution = new LC396RotateFunction();
        System.out.println(solution.maxRotateFunction(new int[]{-2147483648,-2147483648})); // -2147483648
        System.out.println(solution.maxRotateFunction(new int[]{4,3,2,6})); // 26
    }
}
