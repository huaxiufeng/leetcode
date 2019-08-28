package algorithm.java;

import java.util.Arrays;

public class LC88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cursor = m + n - 1;
        int index1 = m - 1, index2 = n - 1;
        while (cursor >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[cursor] = nums1[index1--];
                } else {
                    nums1[cursor] = nums2[index2--];
                }
            } else if (index1 < 0) {
                nums1[cursor] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[cursor] = nums1[index1--];
            }
            cursor--;
        }
    }

    public static void main(String[] args) {
        LC88MergeSortedArray solution = new LC88MergeSortedArray();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
