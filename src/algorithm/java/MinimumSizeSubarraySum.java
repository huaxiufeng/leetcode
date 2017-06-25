package algorithm.java;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 * Created by huaxiufeng on 17/6/25.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLenSlow(int s, int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int len[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    len[j] = j - i + 1;
                }
            }
        }

        int minLen = 0;
        for (int i = 0; i < len.length; i++) {
            if (len[i] > 0 && (len[i] < minLen || 0 == minLen)) {
                minLen = len[i];
            }
        }
        return minLen;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (s <= 1) {
            return 1;
        }
        int len[] = new int[nums.length];

        int lastV = 0;
        int lasSum = 0;
        int lastCursor = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = lasSum - lastV;
            if (sum >= s) {
                len[i] = len[i - 1] - 1;
            } else if (lastCursor == nums.length - 1) {
                if (sum >= s) {
                    len[i] = nums.length - i;
                }
            } else {
                for (int j = lastCursor + 1; j < nums.length; j++) {
                    sum += nums[j];
                    lastCursor = j;
                    if (sum >= s) {
                        len[i] = j - i + 1;
                        break;
                    }
                }
            }
            lasSum = sum;
            lastV = nums[i];

            if (i == 0 && sum < s) {
                return 0;
            }
            if (1 == len[i]) {
                return 1;
            }
        }

        int minLen = 0;
        for (int i = 0; i < len.length; i++) {
            if (len[i] > 0 && (len[i] < minLen || 0 == minLen)) {
                minLen = len[i];
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum soltion = new MinimumSizeSubarraySum();
        int[] arr = {2,3,1,2,4,3};
        System.out.println(soltion.minSubArrayLen(7, arr));
        System.out.println(soltion.minSubArrayLen(1000, arr));
        System.out.println(soltion.minSubArrayLen(0, arr));

        int[] arr2 = {5,1,3,5,10,7,4,9,2,8};
        System.out.println(soltion.minSubArrayLen(15, arr2));
        System.out.println(soltion.minSubArrayLen(1000, arr2));
        System.out.println(soltion.minSubArrayLen(0, arr2));
    }
}
