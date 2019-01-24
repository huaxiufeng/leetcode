package algorithm.java.must;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/5.
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int k = partition(nums, begin, end);
            doQuickSort(nums, begin, k - 1);
            doQuickSort(nums, k + 1, end);
        }
    }

    private int partition(int[] nums, int begin, int end) {
        int lo = begin;
        int hi = end;
        // 第一个值作为枢纽
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            // 后半部分比枢纽小的，就放到前面去
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            // 前半部分比枢纽大的，就放到后面去
            nums[hi] = nums[lo];
        }
        // 把枢纽放到正确的位置
        nums[lo] = pivot;
        // 返回枢纽的位置
        return lo;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add(i + 1);
        }
        for (int k = 0; k < 100; k++) { // 做100次测试
            Collections.shuffle(numList);
            int[] nums = numList.stream().mapToInt(Integer::intValue).toArray();
            solution.quickSort(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
