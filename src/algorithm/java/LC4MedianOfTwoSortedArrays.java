package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/9.
 */
public class LC4MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        double median = findKth(nums1, 0, nums2, 0, total / 2 + 1);
        if (total % 2 == 0) {
            median = (median + findKth(nums1, 0, nums2, 0, total / 2)) / 2.0;
        }
        return median;
    }

    private int findKth(int[] nums1, int num1Begin, int[] nums2, int num2Begin, int k) {
        if (nums1.length - num1Begin > nums2.length - num2Begin) {
            int[] tempArr = nums1;
            int tempBegin = num1Begin;
            nums1 = nums2;
            num1Begin = num2Begin;
            nums2 = tempArr;
            num2Begin = tempBegin;
        }
        int num1Len = nums1.length - num1Begin;
        int num2Len = nums2.length - num2Begin;
        if (num1Len == 0) {
            return nums2[num2Begin + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[num1Begin], nums2[num2Begin]);
        }
        int mid1 = k / 2;
        if (mid1 > num1Len) {
            mid1 = num1Len;
        }
        int mid2 = k - mid1;
        if (nums1[num1Begin + mid1 - 1] < nums2[num2Begin + mid2 - 1]) {
            return findKth(nums1, num1Begin + mid1, nums2, num2Begin, k - mid1);
        } else if (nums1[num1Begin + mid1 - 1] > nums2[num2Begin + mid2 - 1]) {
            return findKth(nums1, num1Begin, nums2, num2Begin + mid2, k - mid2);
        } else {
            return nums1[num1Begin + mid1 - 1];
        }
    }

    public static void main(String[] args) {
        LC4MedianOfTwoSortedArrays solution = new LC4MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6})); // 3.5
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{1, 3})); // 2.0
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10})); // 5.5
    }
}
