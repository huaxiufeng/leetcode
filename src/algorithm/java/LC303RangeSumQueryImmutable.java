package algorithm.java;

public class LC303RangeSumQueryImmutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(2, 5)); // -1
    }
}

class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sums == null || i < 0 || i >= sums.length) {
            return 0;
        }
        return sums[j] - (i == 0 ? 0 : sums[i-1]);
    }
}
