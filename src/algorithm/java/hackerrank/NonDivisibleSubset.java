package algorithm.java.hackerrank;

/**
 * Created by huaxiufeng on 19/3/24.
 */
public class NonDivisibleSubset {

    // 如果i+j可以被k整除，那么i%k+j%k == 0或者k
    static int nonDivisibleSubset(int k, int[] S) {
        int totalPair[][] = new int[k / 2][2];
        int nonDivisible = 0;
        int remainders[] = new int[S.length];
        boolean conatinZeroRemainder = false;
        for (int i = 1; i <= totalPair.length; i++) {
            totalPair[i - 1][0] = i;
            totalPair[i - 1][1] = k - i;
        }

        for (int i = 0; i < S.length; i++) {
            remainders[i] = S[i] % k;
            if (remainders[i] == 0) {
                conatinZeroRemainder = true;
            }
        }

        for (int i = 0; i < totalPair.length; i++) {
            int p1 = totalPair[i][0];
            int p2 = totalPair[i][1];
            int p1C = 0;
            int p2C = 0;
            if (p1 == p2) {
                nonDivisible = nonDivisible + 1;
                break;
            }
            for (int j = 0; j < remainders.length; j++) {
                if (p1 == remainders[j]) {
                    p1C++;
                }
                if (p2 == remainders[j]) {
                    p2C++;
                }
            }

            nonDivisible = nonDivisible + (p1C > p2C ? p1C : p2C);


        }
        if (conatinZeroRemainder) {
            return nonDivisible + 1;
        }
        return nonDivisible;
    }

    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(3, new int[]{1, 7, 2, 4})); // 3
        System.out.println(nonDivisibleSubset(7, new int[]{278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436})); // 11
    }
}
