package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/8.
 */
public class LC300LongestIncreasingSubsequence {

    // 第一反应还是这种方法比较直观
    public int lengthOfLIS_N2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int[] lisLen = new int[nums.length];
        lisLen[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int incrLen = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    incrLen = Math.max(incrLen, lisLen[j] + 1);
                }
            }
            lisLen[i] = incrLen;
            result = Math.max(lisLen[i], result);
        }
        return result;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lis = new int[nums.length]; // 保存最长递增子序列，升序
        lis[0] = nums[0];
        int len = 1; // 最长递增子序列的长度
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis[len-1]) {
                lis[len++] = nums[i];
            } else {
                int pos = findPositionToReplaceSlow(lis, 0, len - 1, nums[i]);
                lis[pos] = nums[i];
            }
        }
        return len;
    }

    // 在递增子序列中找到替换的位置，替换后还是相同长度的递增子序列
    // 也就是找出最小的大于等于X的位置
    private int findPositionToReplace(int[] arr, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    private int findPositionToReplaceSlow(int[] arr, int low, int high, int x) {
        for (int i = low; i <= high; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        LC300LongestIncreasingSubsequence solution = new LC300LongestIncreasingSubsequence();
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // 4
        System.out.println(solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6})); // 6
    }
}
