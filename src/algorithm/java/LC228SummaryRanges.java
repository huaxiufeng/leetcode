package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 19/3/11.
 */
public class LC228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return resultList;
        }
        doSummaryRanges(resultList, nums, 0);
        return resultList;
    }

    private void doSummaryRanges(List<String> resultList, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        int next = index + 1;
        for (; next < nums.length; next++) {
            if (nums[next] != nums[next - 1] + 1) {
                break;
            }
        }
        int begin = index, end = next - 1;
        resultList.add(begin == end ? Integer.toString(nums[begin]) : nums[begin] + "->" + nums[end]);
        doSummaryRanges(resultList, nums, next);
    }

    public static void main(String[] args) {
        LC228SummaryRanges solution = new LC228SummaryRanges();
        System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7})); // ["0->2","4->5","7"]
        System.out.println(solution.summaryRanges(new int[]{0,2,3,4,6,8,9})); // ["0","2->4","6","8->9"]
        System.out.println(solution.summaryRanges(new int[]{0,1,2,3,4,5,6})); // ["0->6"]
    }
}
