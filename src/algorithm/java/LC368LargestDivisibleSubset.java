package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 Si % Sj = 0 or Sj % Si = 0.
 If there are multiple solutions, return any subset is fine.

 * Created by huaxiufeng on 19/3/21.
 */
public class LC368LargestDivisibleSubset {

    private List<Integer> resultList;

    /**
     * 最直观的方法，取所有的子集，然后判断是否满足条件，取最长的作为结果
     * 超时
     */
    // Time Limit Exceeded
    public List<Integer> largestDivisibleSubset0(int[] nums) {
        resultList = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return resultList;
        }
        Arrays.sort(nums);
        doSubsets(new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void doSubsets(List<Integer> temp, int[] nums, int index) {
        if (isDivisible(temp) && temp.size() > resultList.size()) {
            resultList = new ArrayList<>(temp);
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            doSubsets(temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isDivisible(List<Integer> numList) {
        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) % numList.get(i-1) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 模仿最长递增子序列，笨方法
     * 推荐用，简单易理解
     */
    public List<Integer> largestDivisibleSubset1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<Integer>[] list = new List[nums.length];
        list[0] = Arrays.asList(nums[0]);
        List<Integer> result = list[0];
        for (int i = 1; i < nums.length; i++) {
            List<Integer> temp = Arrays.asList(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (list[j].size() + 1 > temp.size()) {
                        temp = new ArrayList<>(list[j]);
                        temp.add(nums[i]);
                    }
                }
            }
            list[i] = temp;
            if (list[i].size() > result.size()) {
                result = list[i];
            }
        }
        return result;
    }

    /**
     * 模仿最长递增子序列，不保存每个位置的结果，只保存前一个位置和长度
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int[] count = new int[nums.length]; // 当前位置符合条件的子序列的长度
        int[] pre = new int[nums.length]; // 当前位置符合条件的自序列的前一个位置
        int maxCount = 1; // 最长的子序列的长度
        int maxIndex = 0; // 最长自序列最后的位置
        for (int i = 0; i < nums.length; i++) {
            int preIndex = -1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        preIndex = j;
                    }
                }
            }
            pre[i] = preIndex;
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new LinkedList<>();
        while (maxIndex >= 0) {
            result.add(0, nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        LC368LargestDivisibleSubset solution = new LC368LargestDivisibleSubset();
        System.out.println(solution.largestDivisibleSubset(new int[]{1,2,3})); // [1,2] (of course, [1,3] will also be ok)
        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8})); // [1,2,4,8]
        System.out.println(solution.largestDivisibleSubset(new int[]{1})); // [1]
        System.out.println(solution.largestDivisibleSubset(new int[]{2,3,5,7,11,13,17,19,23,31,1000000007})); // [2]
    }
}
