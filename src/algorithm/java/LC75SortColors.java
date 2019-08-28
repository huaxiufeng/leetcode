package algorithm.java;

public class LC75SortColors {

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC75SortColors solution = new LC75SortColors();
        solution.sortColors(new int[]{1,2,0}); // [0,1,2]
        solution.sortColors(new int[]{2,0,2,1,1,0}); // [0,0,1,1,2,2]
    }
}
