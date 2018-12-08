package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/8.
 */
public class LC135Candy {

    public int candy(int[] ratings) {
        if (null == ratings || 0 == ratings.length) {
            return 0;
        }
        int[] candyCounts = new int[ratings.length];
        candyCounts[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                if (candyCounts[i - 1] == -1) {
                    // 这种情况下，i-1肯定是1了，i应该为2
                    candyCounts[i] = 2;
                } else {
                    candyCounts[i] = candyCounts[i - 1] + 1;
                }
            } else if (ratings[i] == ratings[i-1]) {
                candyCounts[i] = 1;
            } else if (ratings[i] < ratings[i-1]) {
                candyCounts[i] = -1; // 表示要重新计算，看前面递减的个数才能决定值，最后一个反正是1
            }
        }
        int decreaseCount = 0; // 递减的个数
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (candyCounts[i] == -1) {
                candyCounts[i] = decreaseCount + 1;
                decreaseCount++;
            } else {
                if (decreaseCount > 0) {
                    candyCounts[i] = Math.max(candyCounts[i+1] + 1, candyCounts[i]);
                }
                decreaseCount = 0;
            }
        }
        int candySum = 0;
        for (int n : candyCounts) {
            candySum += n;
        }
        return candySum;
    }

    public static void main(String[] args) {
        LC135Candy solution = new LC135Candy();
        System.out.println(solution.candy(new int[]{1,3,4,5,2})); // 11
        System.out.println(solution.candy(new int[]{1,0,2})); // 5
        System.out.println(solution.candy(new int[]{1,2,2})); // 4
    }
}
