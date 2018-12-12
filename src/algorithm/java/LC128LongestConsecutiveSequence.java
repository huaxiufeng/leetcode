package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huaxiufeng on 18/12/12.
 */
public class LC128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int longestConsecutive = 0;
        for (int n : nums) {
            if (numSet.contains(n - 1)) {
                continue;
            }
            int consecutive = 0;
            int cur = n;
            while (numSet.contains(cur)) {
                cur++;
                consecutive++;
            }
            longestConsecutive = Math.max(longestConsecutive, consecutive);
        }
        return longestConsecutive;
    }

    public static void main(String[] args) {
        LC128LongestConsecutiveSequence solution = new LC128LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
    }
}
